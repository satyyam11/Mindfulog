package com.example.journalapp.controller;

import com.example.journalapp.entity.User;
import com.example.journalapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @PutMapping("/{username}")
    public User updateUser(@PathVariable String username, @RequestBody User user) {
        User existingUser = userService.findByUsername(username);
        if (existingUser != null) {
            user.setId(existingUser.getId()); // Ensure the existing user's ID is retained
            return userService.updateUser(user);
        } else {
            return null; // Or handle the case when the user is not found, e.g., return a 404 status
        }
    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username) {
        User existingUser = userService.findByUsername(username);
        if (existingUser != null) {
            userService.deleteUser(username);
        } else {
            // Handle the case when the user is not found, e.g., return a 404 status
        }
    }
}
