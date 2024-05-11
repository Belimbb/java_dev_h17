package com.example.java_dev_h17.data.service.user;

import com.example.java_dev_h17.data.entity.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService implements UserCrudService{
    private final UserRepository userRepository;

    @Override
    public void add(User user) {
        user.setId(null);
        List<User> users = userRepository.findAll();
        if (!users.contains(user)){
            userRepository.save(user);
            log.info("Added new user to todo list. User: {}", user);
        } else {
            log.info("User wasn't added. Please check if this user hasn't already completed authentication. User: {}", user);
        }
    }

    @Override
    public User getById(Long id) {
        Optional<User> user= userRepository.findById(id);
        if (user.isPresent()){
            log.info("User retrieved from DB. User: {}", user);
            return user.get();
        }
        throw new IllegalArgumentException("Invalid id. Please enter existing id");
    }

    @Override
    public List<User> listAll() {
        List<User> users = userRepository.findAll();

        log.info("List of users retrieved from DB");
        return users;
    }

    @Override
    public void update(User user) {
        userRepository.save(user);

        log.info("User with id {} updated", user.getId());
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);

        log.info("User with id {} removed", id);
    }
}
