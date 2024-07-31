package com.example.journalapp.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "journalEntries")
public class JournalEntry {
    @Id
    private String id;
    private String title;
    private String content;

    @DBRef
    private User user; // Reference to the User entity
}