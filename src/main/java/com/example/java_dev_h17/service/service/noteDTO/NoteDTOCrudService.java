package com.example.java_dev_h17.service.service.noteDTO;

import com.example.java_dev_h17.service.DTO.NoteDTO;

import java.util.List;
import java.util.UUID;

public interface NoteDTOCrudService {
    void add(NoteDTO noteDTO);
    NoteDTO getById(UUID id);
    List<NoteDTO> listAll();
    void update(NoteDTO noteDTO);
    void deleteById(UUID id);
}
