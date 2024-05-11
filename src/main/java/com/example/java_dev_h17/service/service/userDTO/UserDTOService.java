package com.example.java_dev_h17.service.service.userDTO;

import com.example.java_dev_h17.service.DTO.UserDTO;
import com.example.java_dev_h17.data.entity.User;
import com.example.java_dev_h17.data.service.user.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class UserDTOService implements UserDTOCrudService{
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
        UserDTO userDTO = UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .password(user.getPassword())
                .email(user.getEmail())
                .roles(user.getRoles())
                .build();

        return userDTO;
    }

    public User parseToNote(UserDTO userDTO){
        User user = User.builder()
                .id(userDTO.getId())
                .name(userDTO.getName())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail())
                .roles(userDTO.getRoles())
                .build();
        return user;
    }
}
