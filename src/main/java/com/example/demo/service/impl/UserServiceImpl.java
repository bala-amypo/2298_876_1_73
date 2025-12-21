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
    public String registerUser(User user, String roleName) {
        users.put(user.getUsername(), user);
        return user.getUsername(); // String
    }

    @Override
    public String findByUsername(String username) {
        User user = users.get(username);
        return user != null ? user.getUsername() : null;
    }

    @Override
    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return rawPassword.equals(encodedPassword);
    }
}
