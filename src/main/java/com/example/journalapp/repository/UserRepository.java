package com.example.journalapp.repository;

import com.example.journalapp.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);

    void deleteByUsername(String username); // Method to delete user by username

    boolean existsByUsername(String username);
}
