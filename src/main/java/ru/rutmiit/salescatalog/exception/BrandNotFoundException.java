package ru.rutmiit.salescatalog.exception;

public class BrandNotFoundException extends RuntimeException{
    public BrandNotFoundException(Long id) {
        super("Could not find brand " + id);
    }
}
