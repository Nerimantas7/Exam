package lt.techin.exam.security;

import lt.techin.exam.entity.User;
import lt.techin.exam.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Set;
import java.util.stream.Collectors;

public class CustomUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userNameOrEmail) throws UsernameNotFoundException {

        User user = userRepository.findByUsernameOrEmail(userNameOrEmail, userNameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User is not exists with given Username or Email"));
        Set<GrantedAuthority> authorities = user.getRoles().stream()
                .map((role) -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());
        return new org.springframework.security.core.userdetails.User(
                userNameOrEmail,
                user.getPassword(),
                authorities
        );
    }
}
