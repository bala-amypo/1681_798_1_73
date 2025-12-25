package com.example.demo.service.impl;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(
            UserRepository userRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user, String roleName) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role role = roleRepository.findByName(roleName)
                .orElseGet(() -> {
                    Role r = new Role();
                    r.setName(roleName);
                    return roleRepository.save(r);
                });

        user.setRoles(Collections.singleton(role));
        return userRepository.save(user);
    }

    @Override
    public User login(String usernameOrEmail, String rawPassword) {

        User user = userRepository
                .findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow();

        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return user;
    }
}
