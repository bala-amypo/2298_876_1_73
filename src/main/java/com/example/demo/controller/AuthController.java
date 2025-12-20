package com.example.demo.controller;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import java.util.List;


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

        userService.registerUser(user, request.getRole());

        return "REGISTER_OK";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        User user = userService.findByUsername(request.getUsernameOrEmail());

        if (user == null) {
            throw new RuntimeException("Invalid username or email");
        }

        if (!userService.checkPassword(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtTokenProvider.generateToken(user);

        List<String> roles = user.getRoles().stream()
                                .map(r -> r.getName())
                                .toList();

        return new AuthResponse(token, user.getUsername(), roles);
    }
}
