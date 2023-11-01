package ru.rutmiit.salescatalog.entity;

import jakarta.persistence.*;
import ru.rutmiit.salescatalog.entity.enumeration.RoleType;

import java.util.List;

@Entity
@AttributeOverrides({
        @AttributeOverride(name = "created", column = @Column(insertable = false, updatable = false)),
        @AttributeOverride(name = "modified", column = @Column(insertable = false, updatable = false))
})
@Table(name = "user_roles")
public class UserRole extends Base{
    private List<Users> users;
    private RoleType roleType;

    protected UserRole() {};

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role", cascade = CascadeType.REMOVE)
    public List<Users> getUsers() {
        return users;
    }
    public void setUsers(List<Users> users) {
        this.users = users;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name="name", length = 11, nullable = false)
    public RoleType getRoleType() {
        return roleType;
    }
    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
}
