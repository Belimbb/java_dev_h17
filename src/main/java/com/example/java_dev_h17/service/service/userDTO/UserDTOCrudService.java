package com.example.java_dev_h17.service.service.userDTO;

import com.example.java_dev_h17.service.DTO.UserDTO;
import com.example.java_dev_h17.service.exception.UserAlreadyExistException;
import com.example.java_dev_h17.service.exception.UserNotFoundException;

import java.util.List;

public interface UserDTOCrudService {
    void add(UserDTO userDTO) throws UserAlreadyExistException;
    UserDTO getById(Long id);
    List<UserDTO> listAll();
    void update(UserDTO userDTO) throws UserNotFoundException;
    void deleteById(Long id) throws UserNotFoundException;
}
