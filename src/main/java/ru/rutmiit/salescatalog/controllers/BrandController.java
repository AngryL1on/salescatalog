package ru.rutmiit.salescatalog.controllers;

import org.springframework.web.bind.annotation.*;
import ru.rutmiit.salescatalog.exception.BrandNotFoundException;
import ru.rutmiit.salescatalog.services.BrandService;
import ru.rutmiit.salescatalog.services.dtos.BrandDto;

import java.util.UUID;

@RestController
//@RequestMapping("/brands")
public class BrandController {
    private final BrandService brandService;
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/brands")
    Iterable<BrandDto> getAllBrands() {
        return brandService.getAllBrands();
    }
    @GetMapping("brand/{id}")
    BrandDto getBrand(@PathVariable UUID id) {
        return brandService.getBrand(id).orElseThrow(() -> new BrandNotFoundException(id));
    }
    @DeleteMapping("brand/{id}")
    void deleteBrand(@PathVariable UUID id) {
        brandService.deleteBrand(id);
    }
    @PutMapping("brand")
    BrandDto updateBrand(@RequestBody BrandDto brand) {
        return brandService.updateBrand(brand);
    }

    @PostMapping("brand")
    BrandDto createBrand(@RequestBody BrandDto brand) {
        return brandService.addBrand(brand);
    }
}
