package com.example.demo.service;

import com.example.demo.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    User registerUser(User user, String roleName);
}
