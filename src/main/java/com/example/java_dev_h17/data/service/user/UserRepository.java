package com.example.java_dev_h17.data.service.user;

import com.example.java_dev_h17.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
