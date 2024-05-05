package com.example.java_dev_h17.controller.service.userDTO;

import com.example.java_dev_h17.controller.DTO.UserDTO;
import com.example.java_dev_h17.controller.service.noteDTO.NoteDTOService;
import com.example.java_dev_h17.data.entity.User;
import com.example.java_dev_h17.data.service.user.UserService;

import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class UserDTOService implements UserDTOCrudService{
    private static final Logger LOGGER = LoggerFactory.getLogger(NoteDTOService.class);
    private final UserService userService;

    @Override
    public void add(UserDTO userDTO) {

    }

    @Override
    public UserDTO getById(Long id) {
        return null;
    }

    @Override
    public List<UserDTO> listAll() {
        return List.of();
    }

    @Override
    public void update(UserDTO userDTO) {

    }

    @Override
    public void deleteById(Long id) {

    }

    public UserDTO parseToNoteDTO(User user){
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setRoles(user.getRoles());
        userDTO.setNotes(user.getNotes());

        return userDTO;
    }

    public User parseToNote(UserDTO userDTO){
        User user = new User();

        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setRoles(userDTO.getRoles());
        user.setNotes(userDTO.getNotes());
        user.setLastUpdatedDate(LocalDate.now());
        user.setCreatedDate(LocalDate.now());

        return user;
    }
}
