package com.example.sprsecurity.entity;

import lombok.Data;
import javax.persistence.*;


@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private boolean isEnabled = false;
    @Column(length = 60)
    private String password;
}
