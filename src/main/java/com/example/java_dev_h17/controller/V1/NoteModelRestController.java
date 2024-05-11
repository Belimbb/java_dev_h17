package com.example.java_dev_h17.controller.V1;

import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

public interface NoteModelRestController {
    ModelAndView createNote(String title, String content);
    ModelAndView getNote(UUID id);
    ModelAndView listAll();
    ModelAndView updateNote(UUID id, String title, String content);
    ModelAndView deleteNote(UUID id);
}
