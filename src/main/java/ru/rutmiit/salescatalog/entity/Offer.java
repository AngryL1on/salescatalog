package ru.rutmiit.salescatalog.entity;

import jakarta.persistence.*;
import ru.rutmiit.salescatalog.entity.enumeration.EngineType;
import ru.rutmiit.salescatalog.entity.enumeration.TransmissionType;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Represents an offer entity.
 * Each offer has a unique identifier, description, engine type, image URL, mileage, price,
 * transmission type, year, creation and modification timestamps, and is associated with a specific model and seller.
 */
@Entity
public class Offer extends Base {
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @Column(name="description", length = 500, nullable = false)
    private String description;
    @Column(name="engine", length = 11, nullable = false)
    private EngineType engineType;
    @Column(name="imageURL", length = 255, nullable = false)
    private String imageUrl;
    @Column(name="mileage", length = 11, nullable = false)
    private int mileage;
    @Column(name="price", length = 20, nullable = false)
    private BigDecimal price;
    @Column(name="transmission", length = 11, nullable = false)
    private TransmissionType transmissionType;
    @Column(name="year", length = 11, nullable = false)
    private int year;
    @Column(name="created", length = 6, nullable = false)
    private Timestamp created;
    @Column(name="modified", length = 6, nullable = false)
    private Timestamp modified;

    protected Offer() {};

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EngineType getEngineEnum() {
        return engineType;
    }

    public void setEngineEnum(EngineType engineEnum) {
        this.engineType = engineEnum;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TransmissionType getTransmissionEnum() {
        return transmissionType;
    }

    public void setTransmissionEnum(TransmissionType transmissionEnum) {
        this.transmissionType = transmissionEnum;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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
