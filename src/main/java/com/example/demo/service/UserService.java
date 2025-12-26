package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    User getByUsernameOrEmail(String usernameOrEmail);

    boolean checkPassword(User user, String rawPassword);

    User createUser(User user);

    User findByUsername(String username);
}
