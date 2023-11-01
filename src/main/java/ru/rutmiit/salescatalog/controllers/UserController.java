package ru.rutmiit.salescatalog.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rutmiit.salescatalog.exception.UserNotFoundException;
import ru.rutmiit.salescatalog.services.UserService;
import ru.rutmiit.salescatalog.services.dtos.UserDto;

import java.util.List;
import java.util.UUID;

@RestController
//@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    Iterable<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("user/{id}")
    UserDto get(@PathVariable UUID id) {
        return userService.getUser(id).orElseThrow(() -> new UserNotFoundException(id));
    }
    @GetMapping("users/byFirstName")
    public ResponseEntity<List<UserDto>> getUsersByFirstName(@RequestParam String firstName) {
        List<UserDto> users = userService.findUserByFirstName(firstName);
        return ResponseEntity.ok(users);
    }
    @GetMapping("users/byLastName")
    public ResponseEntity<List<UserDto>> getUsersByLastName(@RequestParam String lastName) {
        List<UserDto> users = userService.findUserByLastName(lastName);
        return ResponseEntity.ok(users);
    }
    @PostMapping("user")
    UserDto createUser(@RequestBody UserDto users) {
        return userService.addUser(users);
    }
    @DeleteMapping("user/{id}")
    void deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
    }
    @PutMapping("user")
    UserDto updateUser(@RequestBody UserDto users) {
        return userService.updateUser(users);
    }
}
