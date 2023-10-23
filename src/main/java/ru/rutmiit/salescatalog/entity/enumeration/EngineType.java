package ru.rutmiit.salescatalog.entity.enumeration;

public enum EngineType {
    GASOLINE (0),
    DIESEL (1),
    ELECTRIC (2),
    HYBRID (3);

    private int number;

    EngineType(int number) {
        this.number = number;
    }
}
