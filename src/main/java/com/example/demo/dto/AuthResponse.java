package com.example.demo.dto;

import java.util.List;

public class AuthResponse {
    private String token;
    private String usernameOrEmail;
    private List<String> roles;

    public AuthResponse(String token, String usernameOrEmail, List<String> roles) {
        this.token = token;
        this.usernameOrEmail = usernameOrEmail;
        this.roles = roles;
    }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    public String getUsernameOrEmail() { return usernameOrEmail; }
    public void setUsernameOrEmail(String usernameOrEmail) { this.usernameOrEmail = usernameOrEmail; }
    public List<String> getRoles() { return roles; }
    public void setRoles(List<String> roles) { this.roles = roles; }
}
