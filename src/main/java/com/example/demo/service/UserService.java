package com.example.demo.service;

import com.example.demo.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User registerUser(User user, String roleName);
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    List<User> getAllUsers();
}
