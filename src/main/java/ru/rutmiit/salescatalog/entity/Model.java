package ru.rutmiit.salescatalog.entity;

import jakarta.persistence.*;
import ru.rutmiit.salescatalog.entity.enumeration.CategoryType;

import java.sql.Timestamp;
import java.util.List;

/**
 * Represents a model entity.
 * Each model has a unique identifier, name, category, image URL, start and end year,
 * creation and modification timestamps, and is associated with a specific brand.
 */
@Entity
public class Model extends Base {
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "model", cascade = CascadeType.REMOVE)
    private List<Offer> offers;

    @Column(name="name", length = 255, nullable = false)
    private String name;
    @Column(name="category", length = 11, nullable = false)
    private CategoryType categoryType;
    @Column(name="imageURL", length = 255, nullable = false)
    private String imageUrl;
    @Column(name="startYear", length = 11, nullable = false)
    private int startYear;
    @Column(name="endYear", length = 11, nullable = false)
    private int endYear;
    @Column(name="created", length = 6, nullable = false)
    private Timestamp created;
    @Column(name="modified", length = 6, nullable = false)
    private Timestamp modified;

    protected Model() {};

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
}
