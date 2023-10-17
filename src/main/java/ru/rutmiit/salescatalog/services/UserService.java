package ru.rutmiit.salescatalog.services;

import ru.rutmiit.salescatalog.dtos.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService{
    UserDto register(UserDto users);

    List<UserDto> getAll();

    Optional<UserDto> get(Long id);

    void delete(Long id);

    UserDto update(UserDto users);
}
