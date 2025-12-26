package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User saveUser(User user) { return userRepository.save(user); }

    @Override
    public List<User> getAllUsers() { return userRepository.findAll(); }

    @Override
    public Optional<User> findByUsername(String username) { return userRepository.findByUsername(username); }

    @Override
    public Optional<User> findByEmail(String email) { return userRepository.findByEmail(email); }

    @Override
    public User registerUser(User user, String roleName) {
        Role role = roleRepository.findByName(roleName).orElseThrow(() -> new ResourceNotFoundException("Role not found"));
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        return userRepository.save(user);
    }
}
