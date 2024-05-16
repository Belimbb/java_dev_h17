package com.example.java_dev_h17.service.service.userDTO;

import com.example.java_dev_h17.controller.V2.security.jwt.UserDetailsImpl;
import com.example.java_dev_h17.data.entity.Role;
import com.example.java_dev_h17.data.entity.User;
import com.example.java_dev_h17.data.entity.utils.UserRole;
import com.example.java_dev_h17.data.service.role.RoleService;
import com.example.java_dev_h17.data.service.user.UserService;
import com.example.java_dev_h17.service.DTO.UserDTO;
import com.example.java_dev_h17.service.exception.UserAlreadyExistException;
import com.example.java_dev_h17.service.exception.UserNotFoundException;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@AllArgsConstructor
public class UserDTOService implements UserDTOCrudService, UserDetailsService {
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder encoder;

    @Override
    public void add(UserDTO userDTO) throws UserAlreadyExistException{
        if (userService.existByUsername(userDTO.getUsername())) {
            throw new UserAlreadyExistException(userDTO.getEmail(), userDTO.getUsername());
        }
        if (userService.existByEmail(userDTO.getEmail())) {
            throw new UserAlreadyExistException(userDTO.getEmail(), userDTO.getUsername());
        }

        userDTO.setPassword(encoder.encode(userDTO.getPassword()));

        User user = parseToUser(userDTO);

        Set<Role> roleEntities = roleService.findByNames(Collections.singleton(UserRole.USER));
        user.setRoles(roleEntities);

        userService.add(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userByUsername = userService.findUserByUsername(username);

        return UserDetailsImpl.build(parseToUserDTO(userByUsername));
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
    public void update(UserDTO userDTO) throws UserNotFoundException {

        User user = userService.getById(userDTO.getId()).get();

        userService.update(user);
    }

    @Override
    public void deleteById(Long id) throws UserNotFoundException {
        Optional<User> user = userService.getById(id);

        user.ifPresent(userService::update);
    }


    public UserDTO parseToUserDTO(User user){
        UserDTO userDTO = UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .roles(user.getRoles())
                .build();

        return userDTO;
    }

    public User parseToUser(UserDTO userDTO){
        User user = User.builder()
                .id(userDTO.getId())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail())
                .roles(userDTO.getRoles())
                .build();
        return user;
    }
}