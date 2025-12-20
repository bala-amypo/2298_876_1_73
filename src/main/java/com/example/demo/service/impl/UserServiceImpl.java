package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.model.Role;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final Map<String, User> users = new HashMap<>();

    public UserServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(User user, String roleName) {
        // Dummy registration
        users.put(user.getUsername(), user);
        return user;
    }

    @Override
    public User findByUsername(String username) {
        return users.get(username);
    }

    @Override
    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return rawPassword.equals(encodedPassword);
    }
}
