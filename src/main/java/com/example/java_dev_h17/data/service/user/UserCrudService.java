package com.example.java_dev_h17.data.service.user;

import com.example.java_dev_h17.data.entity.User;

import java.util.List;

public interface UserCrudService {
    void add(User user);
    User getById(Long id);
    List<User> listAll();
    void update(User user);
    void deleteById(Long id);
}
