package ru.rutmiit.salescatalog.services.Impl;

import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rutmiit.salescatalog.services.dtos.UserRoleDto;
import ru.rutmiit.salescatalog.entity.UserRole;
import ru.rutmiit.salescatalog.exception.UserRoleConflictException;
import ru.rutmiit.salescatalog.exception.UserRoleNotFoundException;
import ru.rutmiit.salescatalog.repositories.UserRoleRepository;
import ru.rutmiit.salescatalog.services.UserRoleService;
import ru.rutmiit.salescatalog.util.ValidationUtil;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private UserRoleRepository userRoleRepository;
    private ModelMapper modelMapper;
    private ValidationUtil validationUtil;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRoleRepository = userRoleRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRoleDto addUserRole(UserRoleDto role) {
        if(!this.validationUtil.isValid(role)) {
            this.validationUtil
                    .violations(role)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            throw new IllegalArgumentException("Illegal arguments in Role!");
        }

        UserRole r = modelMapper.map(role, UserRole.class);
        UUID userRoleId = role.getId();

        if (userRoleId == null || userRoleRepository.findById(userRoleId).isEmpty()) {
            return modelMapper.map(userRoleRepository.save(r), UserRoleDto.class);
        } else {
            throw new UserRoleConflictException("A role with this id already exists");
        }
    }

    @Override
    public Optional<UserRoleDto> getUserRole(UUID id) {
        return Optional.ofNullable(modelMapper.map(userRoleRepository.findById(id), UserRoleDto.class));
    }

    @Override
    public List<UserRoleDto> getAllUserRoles() {
        return userRoleRepository.findAll().stream().map((s) -> modelMapper.map(s, UserRoleDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserRoleDto updateUserRole(UserRoleDto role) {
        if(!this.validationUtil.isValid(role)) {
            this.validationUtil
                    .violations(role)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            throw new IllegalArgumentException("Illegal arguments in Role!");
        }

        if (userRoleRepository.findById(role.getId()).isPresent()) {
            return modelMapper.map(userRoleRepository.save(modelMapper.map(role, UserRole.class)), UserRoleDto.class);
        } else {
            throw new UserRoleNotFoundException(role.getId());
        }
    }

    @Override
    public void deleteUserRole(UUID id) {
        if (userRoleRepository.findById(id).isPresent()) {
            userRoleRepository.deleteById(id);
        } else {
            throw new UserRoleNotFoundException(id);
        }
    }
}
