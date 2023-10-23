package ru.rutmiit.salescatalog.services;

import ru.rutmiit.salescatalog.dtos.UserRoleDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRoleService{
    UserRoleDto register(UserRoleDto role);

    List<UserRoleDto> getAll();

    Optional<UserRoleDto> get(UUID id);

    void delete(UUID id);

    UserRoleDto update(UserRoleDto role);
}
