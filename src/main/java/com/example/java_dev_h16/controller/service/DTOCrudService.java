package com.example.java_dev_h16.controller.service;

import com.example.java_dev_h16.controller.entity.NoteDTO;

import java.util.List;

public interface DTOCrudService {
    void add(NoteDTO noteDTO);
    NoteDTO getById(Long id);
    List<NoteDTO> listAll();
    void update(NoteDTO noteDTO);
    void deleteById(Long id);
}
