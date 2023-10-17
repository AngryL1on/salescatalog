package ru.rutmiit.salescatalog.dtos;

import java.sql.Timestamp;

public class BrandDto {
    private Long id;
    private String name;
    private Timestamp created;
    private Timestamp modified;

    public BrandDto(Long id, String name, Timestamp created, Timestamp modified) {
        this.id = id;
        this.name = name;
        this.created = created;
        this.modified = modified;
    }

    protected BrandDto() {};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "BrandDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
