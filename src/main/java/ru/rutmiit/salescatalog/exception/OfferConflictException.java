package ru.rutmiit.salescatalog.exception;

public class OfferConflictException extends RuntimeException {
    public OfferConflictException(String message) {
        super(message);
    }
}
