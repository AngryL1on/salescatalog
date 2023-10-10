package ru.rutmiit.salescatalog.entity;

import jakarta.persistence.*;

@Entity
public class UserRole{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private String role;

}
