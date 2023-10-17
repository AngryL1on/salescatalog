package ru.rutmiit.salescatalog.dtos;

import ru.rutmiit.salescatalog.entity.enumeration.RoleType;

public class UserRoleDto{
    private Long id;
    private RoleType roleType;

    protected UserRoleDto() {};

    public UserRoleDto(Long id, RoleType roleType) {
        this.id = id;
        this.roleType = roleType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleType getRoles() {
        return roleType;
    }

    public void setRoles(RoleType roleType) {
        this.roleType = roleType;
    }

    @Override
    public String toString() {
        return "RoleDto{" +
                "id=" + id +
                ", roles=" + roleType +
                '}';
    }
}
