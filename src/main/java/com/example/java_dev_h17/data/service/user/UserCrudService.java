package com.example.java_dev_h17.data.service.user;

import com.example.java_dev_h17.data.entity.User;
import com.example.java_dev_h17.service.exception.UserNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserCrudService {
    void add(User user);
    Optional<User> getById(Long id) throws UserNotFoundException;
    List<User> listAll();
    void update(User user);
    void deleteById(Long id);
}
