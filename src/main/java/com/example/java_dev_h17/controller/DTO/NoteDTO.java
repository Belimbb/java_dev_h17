package com.example.java_dev_h17.controller.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class NoteDTO {
    private UUID id;
    private String title;
    private String content;
}
