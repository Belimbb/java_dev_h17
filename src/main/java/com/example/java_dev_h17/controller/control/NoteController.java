package com.example.java_dev_h17.controller.control;

import com.example.java_dev_h17.controller.DTO.NoteDTO;
import com.example.java_dev_h17.controller.service.noteDTO.NoteDTOService;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@RequestMapping("/note")
@RestController
@RequiredArgsConstructor
public class NoteController implements NoteRestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(NoteController.class);
    private final NoteDTOService dtoService;

    @PostMapping ("/create")
    @Override
    public ModelAndView createNote(@RequestParam(name = "title") String title, @RequestParam(name = "content") String content) {
        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setTitle(title);
        noteDTO.setContent(content);

        dtoService.add(noteDTO);
        return new ModelAndView("redirect:/note/list");
    }

    @Override
    public ModelAndView getNote(UUID id) {
        NoteDTO note = dtoService.getById(id);
        return null;
    }

    @GetMapping("/list")
    @Override
    public ModelAndView listAll() {
        List<NoteDTO> noteDTOS = dtoService.listAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("notes", noteDTOS);
        return modelAndView;
    }

    @PostMapping("/edit")
    @Override
    public ModelAndView updateNote(@RequestParam(name = "id") UUID id,
                                   @RequestParam(name = "title") String title,
                                   @RequestParam(name = "content") String content) {
        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setId(id);
        noteDTO.setTitle(title);
        noteDTO.setContent(content);

        dtoService.update(noteDTO);
        return new ModelAndView("redirect:/note/list");
    }


    @GetMapping("/edit")
    public ModelAndView transportOnUpdate(@RequestParam(name = "id") UUID id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("note", dtoService.getById(id));
        LOGGER.info("Note transferred on update");
        return modelAndView;
    }

    @PostMapping("/delete")
    @Override
    public ModelAndView deleteNote(@RequestParam(name = "id")UUID id) {
        dtoService.deleteById(id);
        return new ModelAndView("redirect:/note/list");
    }
}