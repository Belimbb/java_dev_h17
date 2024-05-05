package com.example.java_dev_h17.controller.service.noteDTO;

import com.example.java_dev_h17.controller.DTO.NoteDTO;

import java.util.List;
import java.util.UUID;

public interface NoteDTOCrudService {
    void add(NoteDTO noteDTO);
    NoteDTO getById(UUID id);
    List<NoteDTO> listAll();
    void update(NoteDTO noteDTO);
    void deleteById(UUID id);
}
