package ru.rutmiit.salescatalog.entity.enumeration;

public enum TransmissionType{
    MANUAL (0),
    AUTOMATIC (1);

    private int number;

    TransmissionType(int number) {
        this.number = number;
    }
}
