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
        // Ensure the UserService class has a method named createUser
        return userService.createUser(user); // This should match the method name in UserService
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username) {
        return userService.findUserByUsername(username); // This should match the method name in UserService
    }

    @PutMapping("/{username}")
    public User updateUser(@PathVariable String username, @RequestBody User user) {
        User existingUser = userService.findUserByUsername(username);
        if (existingUser != null) {
            user.setId(existingUser.getId()); // Ensure the existing user's ID is retained
            return userService.updateUser(user); // This should match the method name in UserService
        } else {
            return null; // Or handle the case when the user is not found, e.g., return a 404 status
        }
    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username) {
        User existingUser = userService.findUserByUsername(username);
        if (existingUser != null) {
            userService.deleteUserByUsername(username); // This should match the method name in UserService
        } else {
            // Handle the case when the user is not found, e.g., return a 404 status
        }
    }
}
