package com.example.java_dev_h17.data.service.note;

import com.example.java_dev_h17.data.entity.Note;
import com.example.java_dev_h17.service.exception.NoteAlreadyExistException;
import com.example.java_dev_h17.service.exception.NoteNotFoundException;

import java.util.List;
import java.util.UUID;

public interface NoteCrudService {
    void add(Note note) throws NoteAlreadyExistException;
    Note getById(UUID id) throws NoteNotFoundException;
    List<Note> listAll();
    void update(Note note);
    void deleteById(UUID id) throws NoteNotFoundException;
}
