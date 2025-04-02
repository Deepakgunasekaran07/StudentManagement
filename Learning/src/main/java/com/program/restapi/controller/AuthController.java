package com.program.restapi.controller;

import com.program.restapi.dto.AuthRequest;
import com.program.restapi.entity.User;
import com.program.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Register user
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encrypt password
        userService.registerUser(user);
        return "User registered successfully!";
    }

    // Login (dummy method, should implement JWT later)
    @PostMapping("/login")
    public String loginUser(@RequestBody AuthRequest authRequest) {
        User user = userService.findByUsername(authRequest.getUsername());
        if (user != null && passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
            return "Login successful for user: " + user.getUsername();
        }
        return "Invalid credentials!";
    }
}