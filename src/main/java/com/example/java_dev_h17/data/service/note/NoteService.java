package com.example.java_dev_h17.data.service.note;

import com.example.java_dev_h17.data.entity.Note;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class NoteService implements NoteCrudService {
    private final NoteRepository noteRepository;

    @Override
    public void add(Note note) {
        note.setId(null);
        List<Note> notes = noteRepository.findAll();
        if (!notes.contains(note)){
            noteRepository.save(note);
            log.info("Added new note to todo list. Note: {}", note);
        } else {
            log.info("Note wasn't added. Please check if you have already added this note to your todo list. Note: {}", note);
        }
    }

    @Override
    public Note getById(UUID noteId) {
        Optional<Note> note = noteRepository.findById(noteId);
        if (note.isPresent()){
            log.info("Note retrieved from DB. Note: {}", note);
            return note.get();
        }
        throw new IllegalArgumentException("Invalid id. Please enter existing id");
    }

    @Override
    public List<Note> listAll() {
        List<Note> notes = noteRepository.findAll();

        log.info("Todo list retrieved from DB");
        return notes;
    }

    @Override
    public void update(Note note) {
        noteRepository.save(note);

        log.info("Note with id {} updated", note.getId());
    }

    @Override
    public void deleteById(UUID noteId) {
        noteRepository.deleteById(noteId);

        log.info("Note with id {} removed", noteId);
    }
}