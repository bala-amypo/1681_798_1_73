package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByUsername(String input) {
        // This checks BOTH username and email columns
        return userRepository.findByUsername(input)
                .orElseGet(() -> userRepository.findByEmail(input)
                .orElseThrow(() -> new RuntimeException("User not found: " + input)));
    }

    @Override
    public User registerUser(User user, String roleName) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // ... add your role logic here ...
        return userRepository.save(user);
    }
}