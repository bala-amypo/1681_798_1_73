package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.entity.Role;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user, String roleName) {
        Role role = roleRepository.findByName(roleName)
                .orElseGet(() -> roleRepository.save(new Role(null, roleName)));

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(role);

        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findAll()
                .stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElseThrow();
    }

    public User authenticate(String username, String password) {
        User user = findByUsername(username);
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException();
        }
        return user;
    }
}
