package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.UnauthorizedException;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider tokenProvider;

    public AuthController(UserService userService, JwtTokenProvider tokenProvider) {
        this.userService = userService;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/login")
    public String login(@RequestParam String usernameOrEmail, @RequestParam String password) {
        User user = usernameOrEmail.contains("@")
                ? userService.findByEmail(usernameOrEmail).orElseThrow(() -> new ResourceNotFoundException("User not found"))
                : userService.findByUsername(usernameOrEmail).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (!user.getPassword().equals(password)) throw new UnauthorizedException("Invalid credentials");

        return tokenProvider.generateToken(user.getId(), user.getEmail(),
                user.getRoles().stream().map(r -> r.getName()).toList());
    }
}
