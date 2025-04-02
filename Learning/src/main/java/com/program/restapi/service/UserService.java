package com.program.restapi.service;

import com.program.restapi.entity.User;
import com.program.restapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Registers a new user with an encoded password.
     * @param user the user entity to be registered
     */
    public void registerUser(User user) {
        if (user == null || user.getPassword() == null || user.getUsername() == null) {
            throw new IllegalArgumentException("User details cannot be null");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        logger.info("User registered successfully: {}", user.getUsername());
    }

    /**
     * Finds a user by username.
     * @param username the username to search for
     * @return User object if found, otherwise throws an exception
     */
    public User findByUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }

        logger.info("Searching for user with username: {}", username);

        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
    }
}