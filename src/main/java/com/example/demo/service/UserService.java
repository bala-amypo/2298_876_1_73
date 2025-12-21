package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {
    String registerUser(User user, String roleName);
    String findByUsername(String username);
    boolean checkPassword(String rawPassword, String encodedPassword);
}
