package ru.rutmiit.salescatalog.services;

import org.springframework.stereotype.Service;
import ru.rutmiit.salescatalog.services.dtos.BrandDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface BrandService {
    BrandDto addBrand(BrandDto brand);

    Optional<BrandDto> getBrand(UUID id);

    List<BrandDto> getAllBrands();

    List<BrandDto> findBrandByName(String name);

    BrandDto updateBrand(BrandDto brand);

    void deleteBrand(UUID id);
}
