package com.example.java_dev_h17.data.service.note;

import com.example.java_dev_h17.data.entity.Note;

import com.example.java_dev_h17.service.exception.NoteAlreadyExistException;
import com.example.java_dev_h17.service.exception.NoteNotFoundException;
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
    public void add(Note note) throws NoteAlreadyExistException {
        List<Note> notes = noteRepository.findAll();
        if (!notes.contains(note)){
            note.setId(null);
            noteRepository.save(note);
            log.info("Added new note to todo list. Note: {}", note);
        } else {
            log.info("Note wasn't added. Please check if you have already added this note to your todo list. Note: {}", note);
            throw new NoteAlreadyExistException(note.getTitle());
        }
    }

    @Override
    public Note getById(UUID id) throws NoteNotFoundException {
        Optional<Note> note = noteRepository.findById(id);
        if (note.isPresent()){
            log.info("Note retrieved from DB. Note: {}", note);
            return note.get();
        }
        throw new NoteNotFoundException(id);
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
    public void deleteById(UUID id) {
        noteRepository.deleteById(id);

        log.info("Note with id {} removed", id);
    }
}