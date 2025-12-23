package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;

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
            String token = "dummy-token"; // replace with actual JWT
            List<String> rolesList = new ArrayList<>(user.getRoles()); // convert Set -> List
            return new AuthResponse(token, user.getUsername(), rolesList);
        }
        throw new RuntimeException("Invalid username or password");
    }

    // Registration endpoint
    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest registerRequest) {

        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        // convert roles list to set if provided
        Set<String> rolesSet = registerRequest.getRoles() != null
                ? Set.copyOf(registerRequest.getRoles())
                : Set.of("USER"); // default role

        user.setRoles(rolesSet);
        userService.saveUser(user);

        return "User registered successfully!";
    }
}
