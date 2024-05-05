package com.example.java_dev_h17.data.service.note;

import com.example.java_dev_h17.data.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NoteRepository extends JpaRepository<Note, UUID> {

}
