package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // Get user by username
    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Save a new user
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
