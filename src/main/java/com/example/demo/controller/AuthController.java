package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.exception.UnauthorizedException;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider tokenProvider;

    @Autowired
    public AuthController(UserService userService, JwtTokenProvider tokenProvider) {
        this.userService = userService;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        Optional<User> userOpt = userService.getByUsernameOrEmail(authRequest.getUsernameOrEmail());

        if (userOpt.isEmpty() || !userService.checkPassword(userOpt.get(), authRequest.getPassword())) {
            throw new UnauthorizedException("Invalid credentials");
        }

        User user = userOpt.get();
        String token = tokenProvider.generateToken(user.getUsername());

        return ResponseEntity.ok(Map.of(
                "token", token,
                "username", user.getUsername(),
                "email", user.getEmail()
        ));
    }
}
