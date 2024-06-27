package lt.techin.exam.service.impl;

import lombok.AllArgsConstructor;
import lt.techin.exam.dto.LoginDto;
import lt.techin.exam.dto.RegisterDto;
import lt.techin.exam.entity.Role;
import lt.techin.exam.entity.User;
import lt.techin.exam.exception.AdvertAPIException;
import lt.techin.exam.repository.RoleRepository;
import lt.techin.exam.repository.UserRepository;
import lt.techin.exam.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    @Override
    public String register(RegisterDto registerDto) {
        //check username is already exists in database
        if(userRepository.existsByUsername(registerDto.getUserName())){
            throw new AdvertAPIException(HttpStatus.BAD_REQUEST, "Username is already taken!");
        }

        //check email is already exists in database
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new AdvertAPIException(HttpStatus.BAD_REQUEST, "Email is already in use!");
        }

        User user = new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUserName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<>();

        Role userRole = roleRepository.findByName("ROLE_USER");
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);

        return "User registered successfully!";
    }

    @Override
    public String login(LoginDto loginDto) {
        return null;
    }
}
