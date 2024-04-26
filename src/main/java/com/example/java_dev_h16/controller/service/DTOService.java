package com.example.java_dev_h16.controller.service;

import com.example.java_dev_h16.controller.entity.NoteDTO;
import com.example.java_dev_h16.repository.entity.Note;
import com.example.java_dev_h16.repository.service.NoteService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DTOService implements DTOCrudService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DTOService.class);
    private final NoteService noteService;

    public DTOService(NoteService noteService) {
        this.noteService = noteService;
    }

    public void add(NoteDTO noteDTO){
        Note note = new Note();
        note.setTitle(noteDTO.getTitle());
        note.setContent(noteDTO.getContent());

        LOGGER.info("NoteDTO has been transferred to note service. NoteDTO: {}", noteDTO);
        noteService.add(note);
    }

    @Override
    public NoteDTO getById(Long id) {
        Note note = noteService.getById(id);

        LOGGER.info("NoteDTO with id {} has been retrieved from note service", id);
        return parseToNoteDTO(note);
    }

    @Override
    public List<NoteDTO> listAll() {
        List<Note> notes = noteService.listAll();
        List<NoteDTO> noteDTOS = new ArrayList<>();

        for (Note note:notes){
            noteDTOS.add(parseToNoteDTO(note));
        }

        LOGGER.info("Todo list has been retrieved from note service");
        return noteDTOS;
    }

    @Override
    public void update(NoteDTO noteDTO) {
        Note note = parseToNote(noteDTO);

        LOGGER.info("NoteDTO with id {} has been transferred on update", noteDTO.getId());
        noteService.update(note);
    }

    @Override
    public void deleteById(Long id) {
        noteService.deleteById(id);
        LOGGER.info("NoteDTO with id {} has been transferred on delete", id);
    }

    public NoteDTO parseToNoteDTO(Note note){
        NoteDTO noteDTO = new NoteDTO();

        noteDTO.setId(note.getId());
        noteDTO.setTitle(note.getTitle());
        noteDTO.setContent(note.getContent());

        return noteDTO;
    }

    public Note parseToNote(NoteDTO noteDTO){
        Note note = new Note();

        note.setId(noteDTO.getId());
        note.setTitle(noteDTO.getTitle());
        note.setContent(noteDTO.getContent());

        return note;
    }
}