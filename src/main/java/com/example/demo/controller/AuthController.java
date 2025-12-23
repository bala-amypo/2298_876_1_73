package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
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
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        // Authenticate user (pseudo-code, replace with your actual logic)
        User user = userService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        if (user == null) {
            return ResponseEntity.status(401).build();
        }

        // Generate token using username (fixes compilation error)
        String token = jwtTokenProvider.generateToken(user.getUsername());

        // Return token in response
        LoginResponse response = new LoginResponse();
        response.setToken(token);
        response.setUsername(user.getUsername());

        return ResponseEntity.ok(response);
    }
}
