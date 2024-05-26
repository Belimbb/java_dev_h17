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
class NoteServiceTest {

	@Mock
	private NoteRepository noteRepository;

	@InjectMocks
	private NoteService noteService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testAddNote_Success() throws NoteAlreadyExistException {
		// Arrange
		Note note = Note.builder()
				.title("Test Note")
				.content("This is a test note.")
				.build();

		when(noteRepository.findAll()).thenReturn(Collections.emptyList());

		// Act
		noteService.add(note);

		// Assert
		verify(noteRepository, times(1)).save(any(Note.class));
		verify(noteRepository, times(1)).findAll();
	}

	@Test
	void testAddNote_AlreadyExists() {
		// Arrange
		Note note = Note.builder()
				.title("Test Note")
				.content("This is a test note.")
				.build();

		when(noteRepository.findAll()).thenReturn(Collections.singletonList(note));

		// Act & Assert
		NoteAlreadyExistException exception = org.junit.jupiter.api.Assertions.assertThrows(NoteAlreadyExistException.class, () -> {
			noteService.add(note);
		});

		org.junit.jupiter.api.Assertions.assertEquals("Test Note", exception.getMessage());
		verify(noteRepository, times(0)).save(any(Note.class));
		verify(noteRepository, times(1)).findAll();
	}
}
