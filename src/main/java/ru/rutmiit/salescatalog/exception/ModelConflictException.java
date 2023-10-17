package ru.rutmiit.salescatalog.exception;

public class ModelConflictException extends RuntimeException {
    public ModelConflictException(String message) {
        super(message);
    }
}
