package uz.evr.university_evr.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import uz.evr.university_evr.payload.AuthResponse;
import uz.evr.university_evr.payload.LoginDto;
import uz.evr.university_evr.payload.RegisterDto;

public interface AuthService extends UserDetailsService {

    AuthResponse signIn(LoginDto loginDto);

    void signUp(RegisterDto registerDto);
}
