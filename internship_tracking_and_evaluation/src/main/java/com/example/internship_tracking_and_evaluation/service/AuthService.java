package com.example.internship_tracking_and_evaluation.service;

import com.example.internship_tracking_and_evaluation.entity.User;
import com.example.internship_tracking_and_evaluation.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Request body is required");
        }
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new IllegalArgumentException("username is required");
        }
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("password is required");
        }
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("email is required");
        }
        if (user.getRole() == null) {
            throw new IllegalArgumentException("role is required and must be one of: STUDENT, MENTOR, FACULTY, ADMIN");
        }
        // Simple duplicate check by username
        Optional<User> existingUser = userRepository.findAll().stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(user.getUsername()))
                .findFirst();

        if (existingUser.isPresent()) {
            throw new RuntimeException("Username already exists!");
        }

        return userRepository.save(user);
    }

    public boolean loginUser(String username, String password) {
        return userRepository.findAll().stream()
                .anyMatch(u -> u.getUsername().equals(username) && u.getPassword().equals(password));
    }
}
