package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody AuthRequest request) {
        try {
            // 1. Authenticate using the email or username provided
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsernameOrEmail(), request.getPassword())
            );

            // 2. Fetch user (Update your service to handle email lookups!)
            User user = userService.findByUsername(request.getUsernameOrEmail());
            String token = tokenProvider.generateToken(user);

            AuthResponse response = new AuthResponse();
            response.setToken(token);
            response.setUsername(user.getUsername());
            response.setEmail(user.getEmail());
            response.setRoles(user.getRoles().stream().map(r -> r.getName()).toList());
            
            return ResponseEntity.ok(response);

        } catch (AuthenticationException e) {
            // Return 401 Unauthorized instead of letting it bubble up to a 403
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username/email or password");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return ResponseEntity.ok(userService.registerUser(user, request.getRole()));
    }
}