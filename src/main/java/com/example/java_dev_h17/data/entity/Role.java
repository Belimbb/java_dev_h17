package com.example.java_dev_h17.data.entity;

import com.example.java_dev_h17.data.entity.utils.UserRole;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private UserRole name;

    public Role(UserRole name) {
        this.name = name;
    }
}
