package com.example.java_dev_h16.repository.service;

import com.example.java_dev_h16.repository.entity.Note;

import java.util.List;

public interface NoteCrudService {
    void add(Note note);
    Note getById(Long id);
    List<Note> listAll();
    void update(Note note);
    void deleteById(Long id);
}
