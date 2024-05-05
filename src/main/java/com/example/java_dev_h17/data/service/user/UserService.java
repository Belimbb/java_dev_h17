package com.example.java_dev_h17.data.service.user;

import com.example.java_dev_h17.data.entity.User;
import com.example.java_dev_h17.data.service.note.NoteService;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements UserCrudService{
    private static final Logger LOGGER = LoggerFactory.getLogger(NoteService.class);
    private final UserRepository userRepository;

    @Override
    public void add(User user) {
        user.setId(null);
        List<User> users = userRepository.findAll();
        if (!users.contains(user)){
            userRepository.save(user);
            LOGGER.info("Added new user to todo list. User: {}", user);
        } else {
            LOGGER.info("User wasn't added. Please check if this user hasn't already completed authentication. User: {}", user);
        }
    }

    @Override
    public User getById(Long id) {
        Optional<User> user= userRepository.findById(id);
        if (user.isPresent()){
            LOGGER.info("User retrieved from DB. User: {}", user);
            return user.get();
        }
        throw new IllegalArgumentException("Invalid id. Please enter existing id");
    }

    @Override
    public List<User> listAll() {
        List<User> users = userRepository.findAll();

        LOGGER.info("List of users retrieved from DB");
        return users;
    }

    @Override
    public void update(User user) {
        userRepository.save(user);

        LOGGER.info("User with id {} updated", user.getId());
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);

        LOGGER.info("User with id {} removed", id);
    }
}
