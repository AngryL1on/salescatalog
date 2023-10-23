package ru.rutmiit.salescatalog.entity;

import jakarta.persistence.*;

import java.util.UUID;

@MappedSuperclass
public abstract class Base {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id")
    protected UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}

