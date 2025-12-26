package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final Map<String, User> users = new HashMap<>();

    @Override
    public User registerUser(User user, String password) {
        user.setPassword(password);
        users.put(user.getUsername(), user);
        return user;
    }

    @Override
    public User findByUsername(String username) {
        return users.get(username);
    }
}
