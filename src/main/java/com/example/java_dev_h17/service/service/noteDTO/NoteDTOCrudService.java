package com.example.java_dev_h17.service.service.noteDTO;

import com.example.java_dev_h17.service.DTO.NoteDTO;
import com.example.java_dev_h17.service.exception.NoteAlreadyExistException;
import com.example.java_dev_h17.service.exception.NoteNotFoundException;

import java.util.List;
import java.util.UUID;

public interface NoteDTOCrudService {
    void add(NoteDTO noteDTO) throws NoteAlreadyExistException;
    NoteDTO getById(UUID id) throws NoteNotFoundException;
    List<NoteDTO> listAll();
    void update(NoteDTO noteDTO);
    void deleteById(UUID id) throws NoteNotFoundException;
}
