package com.notes.notes_app;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.util.UUID;

@Entity
public class Note {
    @Id
    private String id = UUID.randomUUID().toString(); // Auto-generate string ID

    private String title;
    
    @Column(length = 5000) // Allow longer text
    private String content;

    // Default Constructor
    public Note() {}

    // Constructor with args
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}