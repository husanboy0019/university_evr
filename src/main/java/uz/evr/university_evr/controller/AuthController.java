package uz.evr.university_evr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.evr.university_evr.payload.AuthResponse;
import uz.evr.university_evr.payload.LoginDto;
import uz.evr.university_evr.payload.RegisterDto;
import uz.evr.university_evr.repository.UserRepository;
import uz.evr.university_evr.service.AuthService;
import uz.evr.university_evr.service.MessageService;

@RestController
@RequestMapping(RestConstants.AUTH)
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private SmsService smsService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> addUser(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(authService.signIn(loginDto));
    }

    @PostMapping("/register")
    public void registerToSystem(@RequestBody RegisterDto registerDto) {
        authService.signUp(registerDto);
    }

}
