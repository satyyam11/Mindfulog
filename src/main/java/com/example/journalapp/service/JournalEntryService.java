package com.example.journalapp.service;

import com.example.journalapp.entity.JournalEntry;

import java.util.List;

public interface JournalEntryService {
    JournalEntry save(JournalEntry journalEntry);
    List<JournalEntry> getAllEntries();
    JournalEntry getEntryById(String id);
    JournalEntry updateEntry(String id, JournalEntry journalEntry);
    void deleteEntry(String id);
}
