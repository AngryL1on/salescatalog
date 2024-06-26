package ru.rutmiit.salescatalog.services.dtos;

import ru.rutmiit.salescatalog.entity.enumeration.EngineType;
import ru.rutmiit.salescatalog.entity.enumeration.TransmissionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class OfferDto {
    private UUID id;
    private ModelDto model;
    private UserDto users;
    private String description;
    private EngineType engineType;
    private String imageURL;
    private int mileage;
    private BigDecimal price;
    private TransmissionType transmissionType;
    private int year;
    private LocalDateTime created;
    private LocalDateTime modified;

    public OfferDto(UUID id, ModelDto model, UserDto users, String description, EngineType engineType, String imageURL,
    int mileage, BigDecimal price, TransmissionType transmissionType, int year, LocalDateTime created,
    LocalDateTime modified) {
        this.id = id;
        this.model = model;
        this.users = users;
        this.description = description;
        this.engineType = engineType;
        this.imageURL = imageURL;
        this.mileage = mileage;
        this.price = price;
        this.transmissionType = transmissionType;
        this.year = year;
        this.created = created;
        this.modified = modified;
    }

    protected OfferDto() {};

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ModelDto getModel() {
        return model;
    }

    public void setModel(ModelDto model) {
        this.model = model;
    }

    public UserDto getUsers() {
        return users;
    }

    public void setUsers(UserDto users) {
        this.users = users;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(TransmissionType transmissionType) {
        this.transmissionType = transmissionType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "OfferDto {" +
                "id = " + id +
                ", model = " + model +
                ", user = " + users +
                ", description = '" + description + '\'' +
                ", engineType = " + engineType +
                ", imageURL = '" + imageURL + '\'' +
                ", mileage = " + mileage +
                ", price = " + price +
                ", transmissionType = " + transmissionType +
                ", year = " + year +
                ", created = " + created +
                ", modified = " + modified +
                '}';
    }
}
