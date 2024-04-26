package com.example.java_dev_h16.repository.entity;

import com.example.java_dev_h16.repository.service.NoteService;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String title;

    @Column
    private String content;
}