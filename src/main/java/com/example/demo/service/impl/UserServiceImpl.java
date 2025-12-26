package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final List<User> users = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public User createUser(User user) {
        user.setId(nextId++);
        users.add(user);
        return user;
    }

    @Override
    public Optional<User> getByUsernameOrEmail(String usernameOrEmail) {
        return users.stream()
                .filter(u -> u.getUsername().equals(usernameOrEmail) || u.getEmail().equals(usernameOrEmail))
                .findFirst();
    }

    @Override
    public boolean checkPassword(User user, String rawPassword) {
        return user.getPassword().equals(rawPassword);
    }
}
