package com.example.java_dev_h17.controller.V1;

import com.example.java_dev_h17.service.exception.NoteAlreadyExistException;
import com.example.java_dev_h17.service.exception.NoteNotFoundException;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

public interface NoteModelRestController {
    ModelAndView createNote(String title, String content) throws NoteAlreadyExistException;
    ModelAndView getNote(UUID id) throws NoteNotFoundException;
    ModelAndView listAll();
    ModelAndView updateNote(UUID id, String title, String content);
    ModelAndView deleteNote(UUID id);
}
