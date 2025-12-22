package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
    User registerUser(User user, String roleName);
    User findByUsername(String username);
}
