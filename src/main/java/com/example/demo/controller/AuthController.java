package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider tokenProvider;

    public AuthController(UserService userService, JwtTokenProvider tokenProvider) {
        this.userService = userService;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        return userService.registerUser(user, request.getRole());
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {

        User user = userService.findByEmail(request.getUsernameOrEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        return tokenProvider.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRoles()
                        .stream()
                        .map(r -> r.getName())
                        .collect(Collectors.toList())
        );
    }
}
