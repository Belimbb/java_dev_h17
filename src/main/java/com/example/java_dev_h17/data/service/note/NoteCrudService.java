package com.example.java_dev_h17.data.service.note;

import com.example.java_dev_h17.data.entity.Note;

import java.util.List;
import java.util.UUID;

public interface NoteCrudService {
    void add(Note note);
    Note getById(UUID id);
    List<Note> listAll();
    void update(Note note);
    void deleteById(UUID id);
}
