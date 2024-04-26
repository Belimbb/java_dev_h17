package com.example.java_dev_h16.repository.service;

import com.example.java_dev_h16.repository.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
