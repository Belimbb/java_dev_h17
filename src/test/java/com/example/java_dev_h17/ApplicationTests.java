package com.example.java_dev_h17;

import com.example.java_dev_h17.data.entity.Note;
import com.example.java_dev_h17.data.service.note.NoteRepository;
import com.example.java_dev_h17.data.service.note.NoteService;
import com.example.java_dev_h17.service.DTO.NoteDTO;
import com.example.java_dev_h17.service.exception.NoteAlreadyExistException;
import com.example.java_dev_h17.service.service.noteDTO.NoteDTOService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
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
	void testListAll() {
		// Arrange
		Note note1 = Note.builder()
				.title("Test Note 1")
				.content("This is a test note 1.")
				.build();

		Note note2 = Note.builder()
				.title("Test Note 2")
				.content("This is a test note 2.")
				.build();

		List<Note> expectedNotes = Arrays.asList(note1, note2);

		// Настроим mock так, чтобы findAll() возвращал список заметок
		Mockito.when(noteRepository.findAll()).thenReturn(expectedNotes);

		// Act
		List<Note> actualNotes = noteService.listAll();

		// Assert
		assertEquals(expectedNotes, actualNotes);
	}
}