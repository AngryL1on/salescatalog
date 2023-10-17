package ru.rutmiit.salescatalog.entity;

import jakarta.persistence.*;
import ru.rutmiit.salescatalog.entity.enumeration.RoleType;

import java.util.List;

@Entity
public class UserRole extends Base {

    @OneToMany(mappedBy = "role", cascade = CascadeType.REMOVE)
    private List<User> users;
    @Column(name="name", length = 11, nullable = false)
    private RoleType roleEnum;

    protected UserRole() {};

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public RoleType getRoleEnum() {
        return roleEnum;
    }

    public void setRoleEnum(RoleType roleEnum) {
        this.roleEnum = roleEnum;
    }
}
