package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public String login(@RequestParam String usernameOrEmail, @RequestParam String password) {
        User user = userService.findByUsername(usernameOrEmail)
                        .orElse(userService.findByEmail(usernameOrEmail)
                        .orElseThrow(() -> new RuntimeException("User not found")));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid credentials");
        }

        return tokenProvider.generateToken(user.getId(), user.getEmail(), user.getRoles().stream().map(r -> r.getName()).toList());
    }
}
