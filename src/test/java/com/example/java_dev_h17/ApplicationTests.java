package com.example.java_dev_h17;

import com.example.java_dev_h17.data.entity.Note;
import com.example.java_dev_h17.data.service.note.NoteRepository;
import com.example.java_dev_h17.data.service.note.NoteService;
import com.example.java_dev_h17.service.exception.NoteAlreadyExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ApplicationTests {

	@Mock
	private NoteRepository noteRepository;

	@InjectMocks
	private NoteService noteService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void contextLoads() {
	}

	@Test
	void testAdd() throws NoteAlreadyExistException {
		Note note = Note.builder()
				.title("Test Title")
				.content("Test Content")
				.build();

		when(noteRepository.findAll()).thenReturn(Collections.emptyList());

		// Act
		noteService.add(note);

		// Assert
		verify(noteRepository, times(1)).save(note);
	}
}