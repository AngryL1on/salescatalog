package ru.rutmiit.salescatalog.services;

import org.springframework.stereotype.Service;
import ru.rutmiit.salescatalog.services.dtos.ModelDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface ModelService {
    ModelDto addModel(ModelDto model);

    Optional<ModelDto> getModel(UUID id);

    List<ModelDto> getAllModels();

    List<ModelDto> findModelByName (String name);
    List<ModelDto> findModelByBrandName(String brandName);

    ModelDto updateModel(ModelDto model);

    void deleteModel(UUID id);
}
