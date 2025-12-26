package com.example.demo.service;

import com.example.demo.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getByUsernameOrEmail(String usernameOrEmail);
    boolean checkPassword(User user, String rawPassword);
    User registerUser(User user, String rawPassword);
}
