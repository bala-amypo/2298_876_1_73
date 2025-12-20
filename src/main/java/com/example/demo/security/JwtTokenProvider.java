package com.example.demo.security;

import com.example.demo.model.User;

public class JwtTokenProvider {

    // called with User OR String
    public String generateToken(User user) {
        return "dummy-token";
    }

    public String generateToken(String username) {
        return "dummy-token";
    }

    public boolean validateToken(String token) {
        return true;
    }

    public Long getUserIdFromToken(String token) {
        return 1L;
    }
}
