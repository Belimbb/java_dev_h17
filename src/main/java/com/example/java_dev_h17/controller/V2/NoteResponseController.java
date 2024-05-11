package com.example.java_dev_h17.controller.V2;

import com.example.java_dev_h17.service.DTO.NoteDTO;
import com.example.java_dev_h17.service.service.noteDTO.NoteDTOService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequestMapping("/note/v2")
@RestController
@RequiredArgsConstructor
public class NoteResponseController implements NoteResponseRestController{
    private final NoteDTOService dtoService;

    @PostMapping
    @Override
    public ResponseEntity<NoteDTO> createNote(@RequestBody NoteDTO noteDTO) {
        dtoService.add(noteDTO);
        return ResponseEntity.ok(noteDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteDTO> getNote(@PathVariable UUID id) {
        return ResponseEntity.ok(dtoService.getById(id));
    }

    @GetMapping
    @Override
    public ResponseEntity<List<NoteDTO>> listAll() {
        return ResponseEntity.of(Optional.ofNullable(dtoService.listAll()));
    }

    @Override
    public void updateNote(@RequestBody NoteDTO noteDTO) {

    }

    @Override
    public void deleteNote(UUID id) {

    }
}
