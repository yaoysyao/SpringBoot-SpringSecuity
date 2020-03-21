package com.example.demo.bean;

import org.springframework.stereotype.Component;

import java.util.Set;
@Component
public class user {
    private String id;

    private String username;

    private role role;

    public role getRole() {
        return role;
    }

    public void setRole(role role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}