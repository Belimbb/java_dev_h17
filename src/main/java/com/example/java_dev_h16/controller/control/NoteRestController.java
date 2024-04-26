package com.example.java_dev_h16.controller.control;

import org.springframework.web.servlet.ModelAndView;

public interface NoteRestController {
    ModelAndView createNote(String title, String content);
    ModelAndView getNote(Long id);
    ModelAndView listAll();
    ModelAndView updateNote(Long id, String title, String content);
    ModelAndView deleteNote(Long id);
}
