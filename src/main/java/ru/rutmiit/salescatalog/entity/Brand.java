package ru.rutmiit.salescatalog.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * Represents a brand entity.
 * Each brand has a unique identifier, name, creation and modification timestamps.
 */
@Entity
public class Brand extends Base{

    @OneToMany(mappedBy = "brand", cascade = CascadeType.REMOVE)
    private List<Model> models;

    @Column(name="name", length = 255, nullable = false)
    private String name;
    @Column(name="created", length = 6, nullable = false)
    private Timestamp created;
    @Column(name="modified", length = 6, nullable = false)
    private Timestamp modified;

    protected Brand() {};

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getModified() {
        return modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }
}
