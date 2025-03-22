package com.example.app.controller;

import com.example.app.model.User;
import com.example.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    @Value("${app.collection-name}")
    private String collectionName;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/collection")
    public String getCollectionName() {
        return "Using collection: " + collectionName;
    }

    @GetMapping("/records")
    public ResponseEntity<List<User>> getRecords() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

}
