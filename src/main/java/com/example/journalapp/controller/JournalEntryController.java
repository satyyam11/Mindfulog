package com.example.journalapp.controller;

import com.example.journalapp.entity.JournalEntry;
import com.example.journalapp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/journal-entries")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry journalEntry) {
        return journalEntryService.save(journalEntry);
    }

    @GetMapping
    public List<JournalEntry> getAllEntries() {
        return journalEntryService.getAllEntries();
    }

    @GetMapping("/{id}")
    public JournalEntry getEntryById(@PathVariable String id) {
        return journalEntryService.getEntryById(id);
    }

    @PutMapping("/{id}")
    public JournalEntry updateEntry(@PathVariable String id, @RequestBody JournalEntry journalEntry) {
        return journalEntryService.updateEntry(id, journalEntry);
    }

    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable String id) {
        journalEntryService.deleteEntry(id);
    }
}
