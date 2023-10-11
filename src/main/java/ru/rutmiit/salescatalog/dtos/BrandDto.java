package ru.rutmiit.salescatalog.dtos;

import java.util.Date;

public class BrandDto {
    private String id;
    private String name;
    private Date created;
    private Date modified;

    public BrandDto(String id) {
    }

    public BrandDto(String id, String name, Date created, Date modified) {
        this.id = id;
        this.name = name;
        this.created = created;
        this.modified = modified;
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

    @Override
    public String toString() {
        return "BrandDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
