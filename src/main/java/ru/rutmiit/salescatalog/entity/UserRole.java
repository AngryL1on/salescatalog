package ru.rutmiit.salescatalog.entity;

import jakarta.persistence.*;
import ru.rutmiit.salescatalog.entity.enumeration.RoleType;

import java.util.List;

@Entity
public class UserRole extends Base {
    @OneToMany(mappedBy = "role",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Users> users;

    @Column(name="name", length = 11, nullable = false)
    private RoleType roleType;

    protected UserRole() {};

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
}
