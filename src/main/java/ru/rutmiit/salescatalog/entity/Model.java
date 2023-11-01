package ru.rutmiit.salescatalog.entity;

import jakarta.persistence.*;
import ru.rutmiit.salescatalog.entity.enumeration.CategoryType;

import java.util.List;


@Entity
@Table(name = "models")
public class Model extends Base{
    private Brand brand;
    private List<Offer> offers;
    private String name;
    private CategoryType categoryType;
    private String imageUrl;
    private int startYear;
    private int endYear;

    protected Model() {};

    @ManyToOne
    @JoinColumn(name = "brand_id")
    public Brand getBrand() {
        return brand;
    }
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "model", cascade = CascadeType.REMOVE)
    public List<Offer> getOffers() {
        return offers;
    }
    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    @Column(name="name", length = 255, nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name="category", length = 11, nullable = false)
    public CategoryType getCategoryType() {
        return categoryType;
    }
    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    @Column(name="imageURL", length = 255, nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Column(name="startYear", length = 11, nullable = false)
    public int getStartYear() {
        return startYear;
    }
    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    @Column(name="endYear", length = 11, nullable = false)
    public int getEndYear() {
        return endYear;
    }
    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }
}
