package com.example.java_dev_h17.service.exception;

public class NoteAlreadyExistException extends Throwable {

    private static final String NOTE_ALREADY_EXIST_EXCEPTION_TEXT = "Note with title = %s already exist.";

    public NoteAlreadyExistException(String title) {
        super(String.format(NOTE_ALREADY_EXIST_EXCEPTION_TEXT, title));
    }
}
