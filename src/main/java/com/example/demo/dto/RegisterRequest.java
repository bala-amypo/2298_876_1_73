package com.example.demo.dto;

import java.util.List;

public class RegisterRequest {

    private String username;
    private String password;
    private List<String> roles; // Add this

    public RegisterRequest() {}

    public RegisterRequest(String username, String password, List<String> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Add getter for roles
    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
