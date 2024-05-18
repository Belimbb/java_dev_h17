package com.example.java_dev_h17.service.service.noteDTO;

import com.example.java_dev_h17.service.DTO.NoteDTO;
import com.example.java_dev_h17.data.entity.Note;
import com.example.java_dev_h17.data.service.note.NoteService;

import com.example.java_dev_h17.service.exception.NoteAlreadyExistException;
import com.example.java_dev_h17.service.exception.NoteNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class NoteDTOService implements NoteDTOCrudService {
    private final NoteService noteService;

    public void add(NoteDTO noteDTO) throws NoteAlreadyExistException {
        Note note = Note.builder()
                .title(noteDTO.getTitle())
                .content(noteDTO.getContent())
                .build();

        log.info("NoteDTO has been transferred to note service. NoteDTO: {}", noteDTO);
        noteService.add(note);
    }

    @Override
    public NoteDTO getById(UUID id) throws NoteNotFoundException {
        Note note = noteService.getById(id);

        log.info("NoteDTO with id {} has been retrieved from note service", id);
        return parseToNoteDTO(note);
    }

    @Override
    public List<NoteDTO> listAll() {
        List<Note> notes = noteService.listAll();
        List<NoteDTO> noteDTOS = new ArrayList<>();

        for (Note note:notes){
            noteDTOS.add(parseToNoteDTO(note));
        }

        log.info("Todo list has been retrieved from note service");
        return noteDTOS;
    }

    @Override
    public void update(NoteDTO noteDTO) {
        Note note = parseToNote(noteDTO);

        log.info("NoteDTO with id {} has been transferred on update", noteDTO.getId());
        noteService.update(note);
    }

    @Override
    public void deleteById(UUID id) {
        noteService.deleteById(id);
        log.info("NoteDTO with id {} has been transferred on delete", id);
    }

    public NoteDTO parseToNoteDTO(Note note){

        return NoteDTO
                .builder()
                .id(note.getId())
                .title(note.getTitle())
                .content(note.getContent())
                .build();
    }

    public Note parseToNote(NoteDTO noteDTO){
        return Note
                .builder()
                .id(noteDTO.getId())
                .title(noteDTO.getTitle())
                .content(noteDTO.getContent())
                .build();
    }
}