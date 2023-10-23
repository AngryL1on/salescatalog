package ru.rutmiit.salescatalog.entity.enumeration;

public enum CategoryType{
    CAR(0),
    BUS(1),
    TRUCK(2),
    MOTORCYCLE(3);

    private int number;

    CategoryType(int number) {
        this.number = number;
    }
}
