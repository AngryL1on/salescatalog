package ru.rutmiit.salescatalog.services;

import ru.rutmiit.salescatalog.dtos.ModelDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ModelService {
    ModelDto register(ModelDto model);

    List<ModelDto> getAll();

    Optional<ModelDto> get(UUID id);

    void delete(UUID id);

    ModelDto update(ModelDto model);
}
