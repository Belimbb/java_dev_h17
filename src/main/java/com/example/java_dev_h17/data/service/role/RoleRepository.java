package com.example.java_dev_h17.data.service.role;

import com.example.java_dev_h17.data.entity.Role;
import com.example.java_dev_h17.data.entity.utils.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(UserRole name);

    @Query("FROM Role re WHERE re.name IN :names")
    Set<Role> findByNames(@Param("names") Collection<UserRole> names);
}
