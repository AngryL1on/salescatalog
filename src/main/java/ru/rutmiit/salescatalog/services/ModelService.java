package ru.rutmiit.salescatalog.services;

import ru.rutmiit.salescatalog.dtos.ModelDto;

import java.util.List;
import java.util.Optional;

public interface ModelService {
    ModelDto register(ModelDto model);

    List<ModelDto> getAll();

    Optional<ModelDto> get(Long id);

    void delete(Long id);

    ModelDto update(ModelDto model);
}
