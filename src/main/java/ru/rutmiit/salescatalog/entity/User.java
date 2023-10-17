package ru.rutmiit.salescatalog.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Represents a user entity.
 * Each user has a unique identifier, username, password, first name, last name,
 * active status, role, image URL, creation and modification timestamps.
 */
@Entity
public class User extends Base {
    @ManyToOne
    @JoinColumn(name = "role_id")
    private UserRole role;

    @OneToMany(mappedBy = "users", cascade = CascadeType.REMOVE)
    private List<Offer> offers;
    @Column(name="userName", length = 255, nullable = false)
    private String userName;
    @Column(name="password", length = 255, nullable = false)
    private String password;
    @Column(name="firstName", length = 255, nullable = false)
    private String firstName;
    @Column(name="lastName", length = 255, nullable = false)
    private String lastName;
    private boolean isActive;
    @Column(name="imageURL", length = 255, nullable = false)
    private String imageURL;
    @Column(name="created", length = 6, nullable = false)
    private LocalDateTime created;
    @Column(name="modified", length = 6, nullable = false)
    private LocalDateTime modified;

    protected User() {};

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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
}
