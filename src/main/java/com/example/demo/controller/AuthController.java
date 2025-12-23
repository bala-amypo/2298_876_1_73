package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        // Fetch user by username
        User user = userService.getUserByUsername(authRequest.getUsername());

        // Validate password
        if (user == null || !user.getPassword().equals(authRequest.getPassword())) {
            return ResponseEntity.status(401).body(new AuthResponse("Invalid username or password", null));
        }

        // Generate JWT token
        String token = jwtTokenProvider.generateToken(user.getUsername());

        // Return token in response
        AuthResponse response = new AuthResponse("Login successful", token);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        // Simple registration logic
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        user.setRoles(registerRequest.getRoles()); // make sure RegisterRequest has roles field

        userService.saveUser(user); // Implement saveUser in UserService

        return ResponseEntity.ok("User registered successfully");
    }
}
