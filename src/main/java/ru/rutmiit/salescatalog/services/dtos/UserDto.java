package ru.rutmiit.salescatalog.services.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserDto{
    private UUID id;
    private UserRoleDto userRole;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private String imageURL;
    private LocalDateTime created;
    private LocalDateTime modified;

    public UserDto(UUID id, UserRoleDto userRole, String userName, String password, String firstName, String lastName,
    boolean isActive, String imageURL, LocalDateTime created, LocalDateTime modified) {
        this.id = id;
        this.userRole = userRole;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.imageURL = imageURL;
        this.created = created;
        this.modified = modified;
    }

    protected UserDto() {};

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserRoleDto getRole() {
        return userRole;
    }

    public void setRole(UserRoleDto role) {
        this.userRole = role;
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

    @Override
    public String toString() {
        return "UsersDto{" +
                "id = " + id +
                ", role = " + userRole +
                ", userName = '" + userName + '\'' +
                ", password = '" + password + '\'' +
                ", firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", isActive = " + isActive +
                ", imageURL = '" + imageURL + '\'' +
                ", created = " + created +
                ", modified = " + modified +
                '}';
    }
}
