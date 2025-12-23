package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Login endpoint
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        User user = userService.getUserByUsername(authRequest.getUsername());
        if (user != null && passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
            // generate token logic here if needed
            String token = "dummy-token"; // replace with actual JWT generation
            return new AuthResponse(token, user.getUsername(), user.getRoles());
        }
        throw new RuntimeException("Invalid username or password");
    }

    // Registration endpoint
    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest registerRequest) {

        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        // Set roles
        if (registerRequest.getRoles() != null && !registerRequest.getRoles().isEmpty()) {
            user.setRoles(registerRequest.getRoles()); // assuming User model has setRoles(Set<String>)
        } else {
            user.setRoles(Set.of("USER")); // default role
        }

        userService.saveUser(user);

        return "User registered successfully!";
    }
}
