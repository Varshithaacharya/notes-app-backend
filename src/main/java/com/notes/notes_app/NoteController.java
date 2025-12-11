package com.notes.notes_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
@CrossOrigin(origins = "*") // Allow frontend to access this
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    // Get All Notes
    @GetMapping("/")
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    // Create Note
    @PostMapping("/")
    public Note createNote(@RequestBody Note note) {
        return noteRepository.save(note);
    }

    // Get Single Public Note (We reuse the same endpoint for public view)
    @GetMapping("/public/{id}")
    public Note getNoteById(@PathVariable String id) {
        return noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Note not found"));
    }

    // Update Note
    @PutMapping("/{id}")
    public Note updateNote(@PathVariable String id, @RequestBody Note noteDetails) {
        Note note = noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Note not found"));
        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());
        return noteRepository.save(note);
    }

    // Delete Note
    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable String id) {
        noteRepository.deleteById(id);
    }
}