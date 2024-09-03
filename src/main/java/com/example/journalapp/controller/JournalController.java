package com.example.journalapp.controller;

import com.example.journalapp.entity.JournalEntry;
import com.example.journalapp.entity.User;
import com.example.journalapp.service.JournalEntryService;
import com.example.journalapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/journal")
public class JournalController {

    private final JournalEntryService journalEntryService;
    private final UserService userService;

    @Autowired
    public JournalController(JournalEntryService journalEntryService, UserService userService) {
        this.journalEntryService = journalEntryService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getJournalEntries() {
        return ResponseEntity.ok(journalEntryService.getAllEntries());
    }

    @PostMapping("/add")
    public ResponseEntity<String> addJournalEntry(@RequestBody JournalEntryDTO journalEntryDTO, Principal principal) {
        if (principal == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not authenticated");
        }

        User currentUser = userService.findUserByUsername(principal.getName());  // Get the current user
        JournalEntry journalEntry = new JournalEntry();
        journalEntry.setTitle(journalEntryDTO.getTitle());
        journalEntry.setContent(journalEntryDTO.getContent());
        journalEntry.setUser(currentUser);  // Set the user for the journal entry
        journalEntryService.save(journalEntry);  // Save the entry
        return ResponseEntity.ok("Journal entry added successfully");
    }

    // DTO class for receiving JSON
    public static class JournalEntryDTO {
        private String title;
        private String content;

        // Getters and setters
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
