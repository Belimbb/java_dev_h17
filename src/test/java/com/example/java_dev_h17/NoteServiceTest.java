package com.example.java_dev_h17;

import com.example.java_dev_h17.data.entity.Note;
import com.example.java_dev_h17.data.service.note.NoteRepository;
import com.example.java_dev_h17.data.service.note.NoteService;
import com.example.java_dev_h17.service.exception.NoteAlreadyExistException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.mockito.Mockito.*;

public class NoteServiceTest {
    @Mock
    private NoteRepository noteRepository;

    @InjectMocks
    private NoteService noteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAdd () throws NoteAlreadyExistException {
        Note note = Note.builder()
                .title("Test Title")
                .content("Test Content")
                .build();

        //Can be turned off when needed
        when(noteRepository.findAll()).thenReturn(Collections.emptyList());

        // Act
        noteService.add(note);

        // Assert
        verify(noteRepository, times(1)).save(note);
    }
}