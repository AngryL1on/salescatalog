package ru.rutmiit.salescatalog.controllers;

import org.springframework.web.bind.annotation.*;
import ru.rutmiit.salescatalog.services.UserRoleService;
import ru.rutmiit.salescatalog.services.dtos.UserRoleDto;

import javax.management.relation.RoleNotFoundException;
import java.util.UUID;

@RestController
//@RequestMapping("/roles")
public class UserRoleController{
    private final UserRoleService userRoleService;
    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }
    @GetMapping("roles")
    Iterable<UserRoleDto> getAllRoles() {
        return userRoleService.getAllUserRoles();
    }
    @GetMapping("role/{id}")
    UserRoleDto get(@PathVariable UUID id) throws RoleNotFoundException {
        return userRoleService.getUserRole(id).orElseThrow(() -> new RoleNotFoundException(id.toString()));
    }
    @PostMapping
    UserRoleDto createRole(@RequestBody UserRoleDto role) {
        return userRoleService.addUserRole(role);
    }
    @DeleteMapping("role/{id}")
    void deleteRole(@PathVariable UUID id) {
        userRoleService.deleteUserRole(id);
    }
    @PutMapping("role")
    UserRoleDto updateRole(@RequestBody UserRoleDto role) {
        return userRoleService.updateUserRole(role);
    }
}
