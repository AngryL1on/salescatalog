package ru.rutmiit.salescatalog.entity;

import jakarta.persistence.*;
import ru.rutmiit.salescatalog.entity.enumeration.EngineType;
import ru.rutmiit.salescatalog.entity.enumeration.TransmissionType;

import java.math.BigDecimal;

@Entity
public class Offer extends Base{
    private Model model;
    private Users users;
    private String description;
    private EngineType engineType;
    private String imageUrl;
    private int mileage;
    private BigDecimal price;
    private TransmissionType transmissionType;
    private int year;

    protected Offer() {};

    @ManyToOne
    @JoinColumn(name = "model_id")
    public Model getModel() {
        return model;
    }
    public void setModel(Model model) {
        this.model = model;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public Users getUsers() {
        return users;
    }
    public void setUsers(Users users) {
        this.users = users;
    }

    @Column(name="description", length = 500, nullable = false)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name="engine", length = 11, nullable = false)
    public EngineType getEngineType() {
        return engineType;
    }
    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    @Column(name="imageURL", length = 255, nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Column(name="mileage", length = 11, nullable = false)
    public int getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Column(name="price", length = 20, nullable = false)
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name="transmission", length = 11, nullable = false)
    public TransmissionType getTransmissionType() {
        return transmissionType;
    }
    public void setTransmissionType(TransmissionType transmissionType) {
        this.transmissionType = transmissionType;
    }

    @Column(name="year", length = 11, nullable = false)
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
}
