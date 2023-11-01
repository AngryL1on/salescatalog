package ru.rutmiit.salescatalog.services.Impl;

import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rutmiit.salescatalog.services.dtos.UserDto;
import ru.rutmiit.salescatalog.exception.UserConflictException;
import ru.rutmiit.salescatalog.exception.UserNotFoundException;
import ru.rutmiit.salescatalog.repositories.UserRepository;
import ru.rutmiit.salescatalog.services.UserService;
import ru.rutmiit.salescatalog.entity.Users;
import ru.rutmiit.salescatalog.util.ValidationUtil;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public UserDto addUser(UserDto users) {
        if(!this.validationUtil.isValid(users)) {
            this.validationUtil
                    .violations(users)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            throw new IllegalArgumentException("Illegal arguments in Users for update!");
        }

        Users u = modelMapper.map(users, Users.class);
        UUID userId = u.getId();

        if (u.getId() == null || userRepository.findById(userId).isEmpty()) {
            return modelMapper.map(userRepository.save(u), UserDto.class);
        } else {
            throw new UserConflictException("A user with this id already exists");
        }
    }

    @Override
    public Optional<UserDto> getUser(UUID id) {
        return Optional.ofNullable(modelMapper.map(userRepository.findById(id), UserDto.class));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map((s) -> modelMapper.map(s, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findUserByFirstName(String firstName) {
        return userRepository.findAllByFirstName(firstName).stream().map((s) -> modelMapper.map(s, UserDto.class)).collect(Collectors.toList());
    }
    @Override
    public List<UserDto> findUserByLastName(String lastName) {
        return userRepository.findAllByLastName(lastName).stream().map((s) -> modelMapper.map(s, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto users) {
        if(!this.validationUtil.isValid(users)) {
            this.validationUtil
                    .violations(users)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            throw new IllegalArgumentException("Illegal arguments in Users for update!");
        }

        if (userRepository.findById(users.getId()).isPresent()) {
            return modelMapper.map(userRepository.save(modelMapper.map(users, Users.class)), UserDto.class);
        } else {
            throw new UserNotFoundException(users.getId());
        }
    }

    @Override
    public void deleteUser(UUID id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException(id);
        }
    }
}
