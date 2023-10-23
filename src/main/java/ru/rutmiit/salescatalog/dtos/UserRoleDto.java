package ru.rutmiit.salescatalog.dtos;

import ru.rutmiit.salescatalog.entity.enumeration.RoleType;

import java.util.UUID;

public class UserRoleDto{
    private UUID id;
    private RoleType roleType;

    public UserRoleDto(UUID id, RoleType roleType) {
        this.id = id;
        this.roleType = roleType;
    }

    protected UserRoleDto() {};

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    @Override
    public String toString() {
        return "RoleDto {" +
                "id = " + id +
                ", roleType = " + roleType +
                '}';
    }
}
