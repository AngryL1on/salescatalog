package ru.rutmiit.salescatalog.services;

import org.springframework.stereotype.Service;
import ru.rutmiit.salescatalog.services.dtos.UserRoleDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface UserRoleService{
    UserRoleDto addUserRole(UserRoleDto role);

    Optional<UserRoleDto> getUserRole(UUID id);

    List<UserRoleDto> getAllUserRoles();

    UserRoleDto updateUserRole(UserRoleDto role);

    void deleteUserRole(UUID id);
}
