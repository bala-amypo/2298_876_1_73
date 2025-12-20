package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public String generateToken(String username) {
        // dummy token
        return "dummy-token-for-" + username;
    }

    public boolean validateToken(String token) {
        return token != null && !token.isEmpty();
    }

    public Long getUserIdFromToken(String token) {
        // dummy user id
        return 1L;
    }
}
