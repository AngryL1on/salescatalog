package ru.rutmiit.salescatalog.services;

import ru.rutmiit.salescatalog.dtos.UserDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService{
    UserDto register(UserDto users);

    List<UserDto> getAll();

    Optional<UserDto> get(UUID id);

    void delete(UUID id);

    UserDto update(UserDto users);
}
