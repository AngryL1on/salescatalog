package ru.rutmiit.salescatalog.entity.enumeration;

public enum RoleType{
    USER (0),
    ADMIN (1);

    private int number;

    RoleType(int number) {
        this.number = number;
    }
}
