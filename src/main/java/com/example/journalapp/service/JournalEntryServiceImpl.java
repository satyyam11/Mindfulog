package com.example.journalapp.service;

import com.example.journalapp.entity.JournalEntry;
import com.example.journalapp.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalEntryServiceImpl implements JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Override
    public JournalEntry save(JournalEntry journalEntry) {
        return journalEntryRepository.save(journalEntry);
    }

    @Override
    public List<JournalEntry> getAllEntries() {
        return journalEntryRepository.findAll();
    }

    @Override
    public JournalEntry getEntryById(String id) {
        return journalEntryRepository.findById(id).orElse(null);
    }

    @Override
    public JournalEntry updateEntry(String id, JournalEntry journalEntry) {
        if (journalEntryRepository.existsById(id)) {
            journalEntry.setId(id);
            return journalEntryRepository.save(journalEntry);
        }
        return null;
    }

    @Override
    public void deleteEntry(String id) {
        journalEntryRepository.deleteById(id);
    }
}
