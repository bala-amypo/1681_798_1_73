package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.exception.UnauthorizedException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        User user = userService.getByUsernameOrEmail(request.getUsernameOrEmail())
                .orElseThrow(() -> new UnauthorizedException("Invalid username/email or password"));

        boolean validPassword = userService.checkPassword(user, request.getPassword());
        if (!validPassword) {
            throw new UnauthorizedException("Invalid username/email or password");
        }

        String token = tokenProvider.generateToken(user);
        return ResponseEntity.ok().body(token);
    }
}
