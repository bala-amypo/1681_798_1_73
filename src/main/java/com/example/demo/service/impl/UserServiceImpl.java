package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final List<User> users = new ArrayList<>();

    @Override
    public User getByUsernameOrEmail(String usernameOrEmail) {
        return users.stream()
                .filter(u -> u.getUsername().equals(usernameOrEmail) || u.getEmail().equals(usernameOrEmail))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean checkPassword(User user, String rawPassword) {
        return user != null && user.getPassword().equals(rawPassword);
    }

    @Override
    public User createUser(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User findByUsername(String username) {
        return users.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
}
