package ru.rutmiit.salescatalog.dtos;

import ru.rutmiit.salescatalog.entity.enumeration.CategoryType;

import java.sql.Timestamp;
import java.util.UUID;

public class ModelDto {
    private UUID id;
    private BrandDto brand;
    private String name;
    private CategoryType categoryType;
    private String imageURL;
    private int startYear;
    private int endYear;
    private Timestamp created;
    private Timestamp modified;

    public ModelDto(UUID id, BrandDto brand, String name, CategoryType categoryType, String imageURL, int startYear,
                    int endYear, Timestamp created, Timestamp modified) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.categoryType = categoryType;
        this.imageURL = imageURL;
        this.startYear = startYear;
        this.endYear = endYear;
        this.created = created;
        this.modified = modified;
    }

    protected ModelDto() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BrandDto getBrand() {
        return brand;
    }

    public void setBrand(BrandDto brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
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
        return "ModelDto {" +
                "id = " + id +
                ", brand = " + brand +
                ", name = '" + name + '\'' +
                ", categoryType =" + categoryType +
                ", imageURL = '" + imageURL + '\'' +
                ", startYear = " + startYear +
                ", endYear = " + endYear +
                ", created = " + created +
                ", modified = " + modified +
                '}';
    }
}
