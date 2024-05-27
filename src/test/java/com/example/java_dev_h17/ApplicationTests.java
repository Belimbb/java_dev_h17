package com.example.java_dev_h17;

import org.junit.jupiter.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.java_dev_h17.service.DTO.NoteDTO;
import com.example.java_dev_h17.service.exception.NoteAlreadyExistException;
import com.example.java_dev_h17.service.service.noteDTO.NoteDTOService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED)
@SpringBootTest
class ApplicationTests {

	@Autowired
	NoteDTOService noteDTOService;

	NoteDTO noteDTO;

	@BeforeEach
	public void beforeEach() {
		noteDTO = NoteDTO.builder()
				.title("TestTitle")
				.content("TestContent")
				.build();
	}

	@Test
	void contextLoads() {
		assertThat(noteDTOService).isNotNull();
	}

	@Test
	void testListAll() throws NoteAlreadyExistException {
		//When
		noteDTOService.add(noteDTO);
		List<NoteDTO> listNotes = noteDTOService.listAll();

		//Then
		int expected = 1;
		Assertions.assertEquals(expected, listNotes.size());
	}
}