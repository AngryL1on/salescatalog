package ru.rutmiit.salescatalog.services.Impl;

import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rutmiit.salescatalog.exception.BrandNotFoundException;
import ru.rutmiit.salescatalog.services.dtos.ModelDto;
import ru.rutmiit.salescatalog.entity.Model;
import ru.rutmiit.salescatalog.exception.ModelConflictException;
import ru.rutmiit.salescatalog.exception.ModelNotFoundException;
import ru.rutmiit.salescatalog.repositories.ModelRepository;
import ru.rutmiit.salescatalog.services.ModelService;
import ru.rutmiit.salescatalog.util.ValidationUtil;

import java.util.IllformedLocaleException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService{
    private ModelRepository modelRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public ModelDto addModel(ModelDto model) {
        if (!this.validationUtil.isValid(model)) {
            this.validationUtil
                    .violations(model)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            throw new IllformedLocaleException("Illegal arguments in  Model!");
        }

        Model m = modelMapper.map(model, Model.class);
        UUID modelId = m.getId();

        if (modelId == null || modelRepository.findById(modelId).isEmpty()) {
            return modelMapper.map(modelRepository.save(m), ModelDto.class);
        } else {
            throw new ModelConflictException("A brand with this id already exists");
        }
    }

    @Override
    public Optional<ModelDto> getModel(UUID id) {
        return Optional.ofNullable(modelMapper.map(modelRepository.findById(id), ModelDto.class));
    }

    @Override
    public List<ModelDto> getAllModels() {
        return modelRepository.findAll().stream().map((s) -> modelMapper.map(s, ModelDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ModelDto> findModelByName(String name) {
        return modelRepository.findAllByName(name).stream().map((s) -> modelMapper.map(s, ModelDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ModelDto> findModelByBrandName(String brandName) {
        return modelRepository.findAllByBrandName(brandName).stream().map((s) -> modelMapper.map(s, ModelDto.class)).collect(Collectors.toList());
    }

    @Override
    public ModelDto updateModel(ModelDto model) {
        if (!this.validationUtil.isValid(model)) {
            this.validationUtil
                    .violations(model)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            throw new IllformedLocaleException("Illegal arguments in  Model for update!");
        }

        if (modelRepository.findById(model.getId()).isPresent()) {
            return modelMapper.map(modelRepository.save(modelMapper.map(model, Model.class)), ModelDto.class);
        } else {
            throw new ModelNotFoundException(model.getId());
        }
    }

    @Override
    public void deleteModel(UUID id) {
        if (modelRepository.findById(id).isPresent()) {
            modelRepository.deleteById(id);
        } else {
            throw new BrandNotFoundException(id);
        }
    }
}
