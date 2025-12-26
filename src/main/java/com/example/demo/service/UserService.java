package com.example.demo.service;

import com.example.demo.model.User;

import java.util.Optional;

public interface UserService {

    User registerUser(User user, String roleName);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);
}
