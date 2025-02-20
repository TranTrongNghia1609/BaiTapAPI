package vn.iotstar.jwt.controllers;

import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.iotstar.jwt.entity.User;
import vn.iotstar.jwt.model.LoginResponse;
import vn.iotstar.jwt.model.LoginUserModel;
import vn.iotstar.jwt.model.RegisterUserModel;
import vn.iotstar.jwt.service.AuthenticationService;
import vn.iotstar.jwt.service.JwtService;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;
    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }
    @PostMapping("/signup")
    @Transactional
    public ResponseEntity<User> register(@RequestBody RegisterUserModel registerUser) {
        User registeredUser = authenticationService.signup (registerUser);
        return ResponseEntity.ok(registeredUser);
    }
    @PostMapping(path="/login")
    @Transactional
    public ResponseEntity<LoginResponse> authenticate (@RequestBody LoginUserModel loginUser){
    User authenticatedUser = authenticationService.authenticate(loginUser);
    String jwtToken = jwtService.generateToken(authenticatedUser);
    LoginResponse loginResponse = new LoginResponse(); loginResponse.setToken(jwtToken);
    loginResponse.setExpiresIn (jwtService.getExpirationTime());
    return ResponseEntity.ok(loginResponse);
}
}
