package com.example.demo.service;

import com.example.demo.model.User;
import java.util.List;

public interface UserService {
    User registerUser(User user, String roleName);
    User findByEmail(String email);
    User findByUsername(String username);
    List<User> getAllUsers();
}
