package ru.rutmiit.salescatalog.services.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rutmiit.salescatalog.dtos.UserDto;
import ru.rutmiit.salescatalog.exception.UserConflictException;
import ru.rutmiit.salescatalog.exception.UserNotFoundException;
import ru.rutmiit.salescatalog.repositories.UserRepository;
import ru.rutmiit.salescatalog.services.UserService;
import ru.rutmiit.salescatalog.entity.Users;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto register(UserDto users) {
        Users b = modelMapper.map(users, Users.class);
        if (b.getId() == null || b.getId() == 0 || get(b.getId()).isEmpty()) {
            return modelMapper.map(userRepository.save(b), UserDto.class);
        } else {
            throw new UserConflictException("A user with this id already exists");
        }
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map((s) -> modelMapper.map(s, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<UserDto> get(Long id) {
        return Optional.ofNullable(modelMapper.map(userRepository.findById(id), UserDto.class));
    }

    @Override
    public void delete(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException(id);
        }
    }

    @Override
    public UserDto update(UserDto users) {
        if (userRepository.findById(users.getId()).isPresent()) {
            return modelMapper.map(userRepository.save(modelMapper.map(users, Users.class)), UserDto.class);
        } else {
            throw new UserNotFoundException(users.getId());
        }
    }
}
