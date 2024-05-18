package com.example.java_dev_h17.controller.V1;

import com.example.java_dev_h17.service.DTO.NoteDTO;
import com.example.java_dev_h17.service.exception.NoteAlreadyExistException;
import com.example.java_dev_h17.service.exception.NoteNotFoundException;
import com.example.java_dev_h17.service.service.noteDTO.NoteDTOService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequestMapping("/note/v1")
@RestController
@RequiredArgsConstructor
public class NoteModelController implements NoteModelRestController {
    private final NoteDTOService dtoService;

    @PostMapping ("/create")
    @Override
    public ModelAndView createNote(@RequestParam(name = "title") String title, @RequestParam(name = "content") String content) throws NoteAlreadyExistException {
        NoteDTO noteDTO = NoteDTO.builder()
                .title(title)
                .content(content)
                .build();

        dtoService.add(noteDTO);
        return new ModelAndView("redirect:/note/v1/list");
    }

    @Override
    public ModelAndView getNote(UUID id) throws NoteNotFoundException {
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
        NoteDTO noteDTO = NoteDTO.builder()
                .id(id)
                .title(title)
                .content(content)
                .build();

        dtoService.update(noteDTO);
        return new ModelAndView("redirect:/note/v1/list");
    }


    @GetMapping("/edit")
    public ModelAndView transportOnUpdate(@RequestParam(name = "id") UUID id) throws NoteNotFoundException {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("note", dtoService.getById(id));
        log.info("Note transferred on update");
        return modelAndView;
    }

    @PostMapping("/delete")
    @Override
    public ModelAndView deleteNote(@RequestParam(name = "id")UUID id) {
        dtoService.deleteById(id);
        return new ModelAndView("redirect:/note/v1/list");
    }
}