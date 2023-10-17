package ru.rutmiit.salescatalog.exception;

public class UserRoleNotFoundException extends RuntimeException {
    public UserRoleNotFoundException(Long id) {
        super("Could not find role " + id);
    }
}
