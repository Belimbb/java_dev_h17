package com.example.java_dev_h17.data.service.user;

import com.example.java_dev_h17.controller.V2.security.jwt.UserDetailsImpl;
import com.example.java_dev_h17.data.entity.User;

import com.example.java_dev_h17.service.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
        List<User> users = userRepository.findAll();
        if (!users.contains(user)){
            user.setId(null);
            userRepository.save(user);
            log.info("Added new user to todo list. User: {}", user);
        } else {
            log.info("User wasn't added. Please check if this user hasn't already completed authentication. User: {}", user);
        }
    }

    @Override
    public Optional<User> getById(Long id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);

        user.ifPresent(u -> log.info("User retrieved from DB: {}", u));
        user.orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        return user;
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

    public User findUserByUsername (String username) throws UsernameNotFoundException{
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
    }

    public Boolean existByUsername (String username){
        return userRepository.existsByUsername(username);
    }

    public Boolean existByEmail (String email){
        return userRepository.existsByEmail(email);
    }
}
