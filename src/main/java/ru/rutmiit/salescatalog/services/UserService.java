package ru.rutmiit.salescatalog.services;

import org.springframework.stereotype.Service;
import ru.rutmiit.salescatalog.services.dtos.UserDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface UserService{
    UserDto addUser(UserDto users);

    Optional<UserDto> getUser(UUID id);

    List<UserDto> getAllUsers();

    List<UserDto> findUserByFirstName(String firstName);
    List<UserDto> findUserByLastName(String lastName);

    UserDto updateUser(UserDto users);

    void deleteUser(UUID id);
}
