package com.example.java_dev_h17.data.service.role;

import com.example.java_dev_h17.data.entity.Role;
import com.example.java_dev_h17.data.entity.utils.UserRole;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@AllArgsConstructor
@Service
public class RoleService implements RoleCrudService{
    private final RoleRepository roleRepository;

    @Override
    public void add(Role role) {
        Set<Role> roles = new HashSet<>(roleRepository.findAll());
        if (!roles.contains(role)){
            roleRepository.save(role);
            log.info("Added new role. Role: {}", role);
        } else {
            log.info("Role wasn't added. Please check if you have already added this role. Role: {}", role);
        }
    }

    @Override
    public Role getById(Integer id) {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isPresent()){
            log.info("Role retrieved from DB. Role: {}", role);
            return role.get();
        }
        throw new IllegalArgumentException("Invalid id. Please enter existing id");
    }

    @Override
    public Set<Role> listAll() {
        Set<Role> roles = new HashSet<>(roleRepository.findAll());

        log.info("Set of roles retrieved from DB");
        return roles;
    }

    @Override
    public void update(Role role) {
        roleRepository.save(role);

        log.info("Role with id {} updated", role.getId());
    }

    @Override
    public void deleteById(Integer id) {
        roleRepository.deleteById(id);

        log.info("Role with id {} removed", id);
    }

    public Optional<Role> findByName (UserRole name){
        return roleRepository.findByName(name);
    }

    public Set<Role> findByNames (Collection<UserRole> names){
        return roleRepository.findByNames(names);
    }
}
