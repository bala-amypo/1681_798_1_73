package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam String usernameOrEmail, @RequestParam String password) {
        // Get user from service
        User user = userService.getByUsernameOrEmail(usernameOrEmail);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        // Check password
        boolean valid = userService.checkPassword(user, password);
        if (!valid) {
            throw new RuntimeException("Invalid password");
        }

        return "Login successful for user: " + user.getUsername();
    }
}
