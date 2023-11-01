package ru.rutmiit.salescatalog.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rutmiit.salescatalog.exception.ModelNotFoundException;
import ru.rutmiit.salescatalog.services.ModelService;
import ru.rutmiit.salescatalog.services.dtos.ModelDto;

import java.util.List;
import java.util.UUID;

@RestController
//@RequestMapping("/models")
public class ModelController {
    private final ModelService modelService;
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/models")
    Iterable<ModelDto> getAllModels() {
        return modelService.getAllModels();
    }
    @GetMapping("model/{id}")
    ModelDto getModel(@PathVariable UUID id) {
        return modelService.getModel(id).orElseThrow(() -> new ModelNotFoundException(id));
    }
    @GetMapping("models/byBrandName")
    public ResponseEntity<List<ModelDto>> getModelByBrandName(@RequestParam String brandName) {
        List<ModelDto> models = modelService.findModelByBrandName(brandName);
        return ResponseEntity.ok(models);
    }

    @PostMapping("model")
    ModelDto createModel(@RequestBody ModelDto model) {
        return modelService.addModel(model);
    }
    @DeleteMapping("model/{id}")
    void deleteModel(@PathVariable UUID id) {
        modelService.deleteModel(id);
    }
    @PutMapping("model")
    ModelDto update(@RequestBody ModelDto model) {
        return modelService.updateModel(model);
    }
}
