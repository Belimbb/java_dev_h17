package com.example.java_dev_h17.controller.service.userDTO;

import com.example.java_dev_h17.controller.DTO.UserDTO;

import java.util.List;

public interface UserDTOCrudService {
    void add(UserDTO userDTO);
    UserDTO getById(Long id);
    List<UserDTO> listAll();
    void update(UserDTO userDTO);
    void deleteById(Long id);
}
