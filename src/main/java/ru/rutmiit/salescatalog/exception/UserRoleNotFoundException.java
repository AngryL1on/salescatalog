package ru.rutmiit.salescatalog.exception;

import java.util.UUID;

public class UserRoleNotFoundException extends RuntimeException {
    public UserRoleNotFoundException(UUID id) {
        super("Could not find role " + id);
    }
}
