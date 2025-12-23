package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User authenticate(String username, String password) {
        // For testing, return a dummy user
        if ("admin".equals(username) && "admin".equals(password)) {
            return new User(1L, "admin", "admin");
        }
        return null;
    }
}
