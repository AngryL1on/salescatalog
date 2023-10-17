package ru.rutmiit.salescatalog.exception;

public class ModelNotFoundException extends RuntimeException {
    public ModelNotFoundException(Long id) {
        super("Could not find model " + id);
    }
}
