package com.example.journalapp.repository;

import com.example.journalapp.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    // Method to find a user by username
    Optional<User> findByUsername(String username);

    // Method to delete a user by username
    void deleteByUsername(String username);

    // Method to find a user by ID (inherited from MongoRepository)
    // Optional<User> findById(String id);
}
