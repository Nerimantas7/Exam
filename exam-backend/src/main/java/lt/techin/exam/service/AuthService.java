package lt.techin.exam.service;

import lt.techin.exam.dto.LoginDto;
import lt.techin.exam.dto.RegisterDto;

public interface AuthService {

    String register(RegisterDto registerDto);

    String login(LoginDto loginDto);

}
