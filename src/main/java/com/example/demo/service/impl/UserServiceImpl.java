package com.example.demo.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(
            UserRepository userRepo,
            RoleRepository roleRepo,
            PasswordEncoder passwordEncoder) {

        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(User user, String roleName) {
        Role role = roleRepo.findByName(roleName)
                .orElseGet(() -> roleRepo.save(new Role(roleName)));

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(role);
        return userRepo.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username).orElseThrow();
    }
}
