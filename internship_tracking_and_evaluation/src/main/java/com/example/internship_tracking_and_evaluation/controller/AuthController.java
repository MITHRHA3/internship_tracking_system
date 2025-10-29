package com.example.internship_tracking_and_evaluation.controller;

import com.example.internship_tracking_and_evaluation.entity.User;
import com.example.internship_tracking_and_evaluation.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")

public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return authService.registerUser(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        boolean isAuthenticated = authService.loginUser(user.getUsername(), user.getPassword());
        return isAuthenticated ? "Login successful!" : "Invalid username or password.";
    }
}
