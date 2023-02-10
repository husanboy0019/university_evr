package uz.evr.university_evr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.evr.university_evr.entity.User;
import uz.evr.university_evr.payload.AuthResponse;
import uz.evr.university_evr.payload.LoginDto;
import uz.evr.university_evr.payload.RegisterDto;
import uz.evr.university_evr.repository.UserRepository;
import uz.evr.university_evr.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SmsService smsService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    @Transactional
    public AuthResponse signIn(LoginDto loginRequest) {
        return new AuthResponse();
    }

    @Override
    public void signUp(RegisterDto registerDto) {
        User user = new User(registerDto.getUsername(), registerDto.getPhoneNumber());
        userRepository.save(user);
    }

}
