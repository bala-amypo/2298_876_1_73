package com.example.demo.controller;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        // service returns String now
        return userService.registerUser(user, request.getRole());
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        // service returns username (String), not User
        String username = userService.findByUsername(request.getUsername());

        if (username != null &&
            userService.checkPassword(request.getPassword(), request.getPassword())) {
            // dummy password check (matches your current logic)
            return new AuthResponse(jwtTokenProvider.generateToken(username));
        }

        return new AuthResponse("invalid-login");
    }
}
