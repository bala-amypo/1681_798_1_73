package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String usernameOrEmail,
                                        @RequestParam String password) {

        User user = userService.getByUsernameOrEmail(usernameOrEmail); // returns User, not Optional

        if (user != null) {
            if (userService.checkPassword(user, password)) {
                return ResponseEntity.ok("Login successful!");
            } else {
                return ResponseEntity.status(401).body("Invalid password");
            }
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }
}
