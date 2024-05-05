package com.example.java_dev_h17.data.service.note;

import com.example.java_dev_h17.data.entity.Note;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class NoteService implements NoteCrudService {
    private static final Logger LOGGER = LoggerFactory.getLogger(NoteService.class);
    private final NoteRepository noteRepository;

    @Override
    public void add(Note note) {
        note.setId(null);
        List<Note> notes = noteRepository.findAll();
        if (!notes.contains(note)){
            noteRepository.save(note);
            LOGGER.info("Added new note to todo list. Note: {}", note);
        } else {
            LOGGER.info("Note wasn't added. Please check if you have already added this note to your todo list. Note: {}", note);
        }
    }

    @Override
    public Note getById(UUID noteId) {
        Optional<Note> note = noteRepository.findById(noteId);
        if (note.isPresent()){
            LOGGER.info("Note retrieved from DB. Note: {}", note);
            return note.get();
        }
        throw new IllegalArgumentException("Invalid id. Please enter existing id");
    }

    @Override
    public List<Note> listAll() {
        List<Note> notes = noteRepository.findAll();

        LOGGER.info("Todo list retrieved from DB");
        return notes;
    }

    @Override
    public void update(Note note) {
        noteRepository.save(note);

        LOGGER.info("Note with id {} updated", note.getId());
    }

    @Override
    public void deleteById(UUID noteId) {
        noteRepository.deleteById(noteId);

        LOGGER.info("Note with id {} removed", noteId);
    }
}