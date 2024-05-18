package com.example.java_dev_h17.controller.V2.control;

import com.example.java_dev_h17.service.DTO.NoteDTO;
import com.example.java_dev_h17.service.exception.NoteAlreadyExistException;
import com.example.java_dev_h17.service.exception.NoteNotFoundException;
import com.example.java_dev_h17.service.service.noteDTO.NoteDTOService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@Validated
@RequestMapping("/note/v2")
@RestController
@RequiredArgsConstructor
public class NoteResponseController implements NoteResponseRestController{
    private final NoteDTOService dtoService;

    @PostMapping
    @Override
    public ResponseEntity<NoteDTO> createNote(@RequestBody NoteDTO noteDTO) throws NoteAlreadyExistException {
        dtoService.add(noteDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(noteDTO);
    }


    @GetMapping("/{id}")
    public ResponseEntity<NoteDTO> getNote(@PathVariable UUID id) throws NoteNotFoundException {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(dtoService.getById(id));
    }

    @GetMapping ("/list")
    @Override
    public ResponseEntity<List<NoteDTO>> listAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dtoService.listAll());
    }

    @PutMapping("/{id}")
    @Override
    public void  updateNote(@RequestBody NoteDTO noteDTO) {
        dtoService.update(noteDTO);
    }

    @DeleteMapping ("/{id}")
    @Override
    public void deleteNote(UUID id) {
        dtoService.deleteById(id);
    }
}
