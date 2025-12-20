package com.example.demo.security;

import com.example.demo.model.User;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {
    public String generateToken(User user) { return "DUMMY_TOKEN"; }
    public Long getUserIdFromToken(String token) { return 1L; }
    public boolean validateToken(String token) { return true; }
}
