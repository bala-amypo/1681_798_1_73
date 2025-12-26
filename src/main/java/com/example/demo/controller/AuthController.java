package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User loginRequest) {
        Optional<User> optionalUser = userService.getByUsernameOrEmail(loginRequest.getUsername());
        User user = optionalUser.orElseThrow(() -> new RuntimeException("User not found"));

        if (userService.checkPassword(user, loginRequest.getPassword())) {
            return "Login successful for user: " + user.getUsername();
        } else {
            throw new RuntimeException("Invalid password");
        }
    }
}
