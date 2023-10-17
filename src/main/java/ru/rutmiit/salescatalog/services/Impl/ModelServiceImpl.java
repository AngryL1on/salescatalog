package ru.rutmiit.salescatalog.services.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rutmiit.salescatalog.dtos.ModelDto;
import ru.rutmiit.salescatalog.entity.Model;
import ru.rutmiit.salescatalog.exception.ModelConflictException;
import ru.rutmiit.salescatalog.exception.ModelNotFoundException;
import ru.rutmiit.salescatalog.repositories.ModelRepository;
import ru.rutmiit.salescatalog.services.ModelService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService{

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public ModelDto register(ModelDto model) {
        Model b = modelMapper.map(model, Model.class);
        if (b.getId() == null || b.getId() == 0 || get(b.getId()).isEmpty()) {
            return modelMapper.map(modelRepository.save(b), ModelDto.class);
        } else {
            throw new ModelConflictException("A model with this id already exists");
        }
    }

    @Override
    public List<ModelDto> getAll() {
        return modelRepository.findAll().stream().map((s) -> modelMapper.map(s, ModelDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<ModelDto> get(Long id) {
        return Optional.ofNullable(modelMapper.map(modelRepository.findById(id), ModelDto.class));
    }

    @Override
    public void delete(Long id) {
        if (modelRepository.findById(id).isPresent()) {
            modelRepository.deleteById(id);
        } else {
            throw new ModelNotFoundException(id);
        }
    }

    @Override
    public ModelDto update(ModelDto model) {
        if (modelRepository.findById(model.getId()).isPresent()) {
            return modelMapper.map(modelRepository.save(modelMapper.map(model, Model.class)), ModelDto.class);
        } else {
            throw new ModelNotFoundException(model.getId());
        }
    }
}
