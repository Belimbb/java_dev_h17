package com.example.java_dev_h17.controller.DTO;

import com.example.java_dev_h17.data.entity.Note;
import com.example.java_dev_h17.data.entity.Role;

import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String password;
    private String email;
    private Set<Role> roles = new HashSet<>();
    private List<Note> notes;
}
