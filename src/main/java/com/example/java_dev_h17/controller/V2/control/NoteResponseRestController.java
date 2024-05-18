package com.example.java_dev_h17.controller.V2.control;

import com.example.java_dev_h17.service.DTO.NoteDTO;
import com.example.java_dev_h17.service.exception.NoteAlreadyExistException;
import com.example.java_dev_h17.service.exception.NoteNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface NoteResponseRestController {
    ResponseEntity<NoteDTO> createNote(@RequestBody NoteDTO noteDTO) throws NoteAlreadyExistException;
    ResponseEntity<NoteDTO> getNote(UUID id) throws NoteNotFoundException;
    ResponseEntity<List<NoteDTO>> listAll();
    void updateNote(@RequestBody NoteDTO noteDTO);
    void deleteNote(UUID id) throws NoteNotFoundException;
}
