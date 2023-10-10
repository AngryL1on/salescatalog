package ru.rutmiit.salescatalog.entity;

import jakarta.persistence.*;

import java.util.Date;

/**
 * Represents a brand entity.
 * Each brand has a unique identifier, name, creation and modification timestamps.
 */
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(nullable = false)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date modified;

    public Brand() {
        // Default constructor
    }

    public Brand(String name) {
        this.name = name;
        this.created = new Date();
        this.modified = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.modified = new Date();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
