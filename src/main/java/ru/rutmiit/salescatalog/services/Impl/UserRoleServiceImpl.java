package ru.rutmiit.salescatalog.services.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rutmiit.salescatalog.dtos.UserRoleDto;
import ru.rutmiit.salescatalog.entity.UserRole;
import ru.rutmiit.salescatalog.exception.UserRoleConflictException;
import ru.rutmiit.salescatalog.exception.UserRoleNotFoundException;
import ru.rutmiit.salescatalog.repositories.UserRoleRepository;
import ru.rutmiit.salescatalog.services.UserRoleService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository roleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRoleDto register(UserRoleDto role) {
        UserRole b = modelMapper.map(role, UserRole.class);
        if (b.getId() == null || b.getId() == 0 || get(b.getId()).isEmpty()) {
            return modelMapper.map(userRoleRepository.save(b), UserRoleDto.class);
        } else {
            throw new UserRoleConflictException("A role with this id already exists");
        }
    }

    @Override
    public List<UserRoleDto> getAll() {
        return userRoleRepository.findAll().stream().map((s) -> modelMapper.map(s, UserRoleDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<UserRoleDto> get(Long id) {
        return Optional.ofNullable(modelMapper.map(userRoleRepository.findById(id), UserRoleDto.class));
    }

    @Override
    public void delete(Long id) {
        if (userRoleRepository.findById(id).isPresent()) {
            userRoleRepository.deleteById(id);
        } else {
            throw new UserRoleNotFoundException(id);
        }
    }

    @Override
    public UserRoleDto update(UserRoleDto role) {
        if (userRoleRepository.findById(role.getId()).isPresent()) {
            return modelMapper.map(userRoleRepository.save(modelMapper.map(role, UserRole.class)), UserRoleDto.class);
        } else {
            throw new UserRoleNotFoundException(role.getId());
        }
    }
}
