package com.example.java_dev_h17.data.service.role;

import com.example.java_dev_h17.data.entity.Role;

import java.util.Set;

public interface RoleCrudService {
    void add(Role role);
    Role getById(Integer id);
    Set<Role> listAll();
    void update(Role role);
    void deleteById(Integer id);
}
