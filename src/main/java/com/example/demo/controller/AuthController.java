package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public String login(@RequestParam String email) {
        User user = userService.findByEmail(email);
        if (user == null) return "Invalid credentials";

        return tokenProvider.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRoles().stream().map(r -> r.getName()).collect(Collectors.toList())
        );
    }

    @PostMapping("/register")
    public User register(@RequestParam String username,
                         @RequestParam String email,
                         @RequestParam String password,
                         @RequestParam String roleName) {
        User user = new User(username, email, password, null);
        return userService.registerUser(user, roleName);
    }
}
