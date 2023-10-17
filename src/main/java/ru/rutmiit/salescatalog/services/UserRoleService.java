package ru.rutmiit.salescatalog.services;

import ru.rutmiit.salescatalog.dtos.UserRoleDto;

import java.util.List;
import java.util.Optional;

public interface UserRoleService{
    UserRoleDto register(UserRoleDto role);

    List<UserRoleDto> getAll();

    Optional<UserRoleDto> get(Long id);

    void delete(Long id);

    UserRoleDto update(UserRoleDto role);
}
