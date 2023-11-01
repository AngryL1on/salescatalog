package ru.rutmiit.salescatalog.services.Impl;

import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rutmiit.salescatalog.services.dtos.BrandDto;
import ru.rutmiit.salescatalog.entity.Brand;
import ru.rutmiit.salescatalog.exception.BrandConflictException;
import ru.rutmiit.salescatalog.exception.BrandNotFoundException;
import ru.rutmiit.salescatalog.repositories.BrandRepository;
import ru.rutmiit.salescatalog.services.BrandService;
import ru.rutmiit.salescatalog.util.ValidationUtil;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService{

    private BrandRepository brandRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public BrandDto addBrand(BrandDto brand) {
        if (!this.validationUtil.isValid(brand)) {
            this.validationUtil
                    .violations(brand)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            throw new IllegalArgumentException("Illegal arguments in Brand!");
        }

        Brand b = modelMapper.map(brand, Brand.class);
        UUID brandId = b.getId();

        if (brandId == null || brandRepository.findById(brandId).isEmpty()) {
            return modelMapper.map(brandRepository.save(b), BrandDto.class);
        } else {
            throw new BrandConflictException("A brand with this id already exists");
        }
    }

    @Override
    public Optional<BrandDto> getBrand(UUID id) {
        return Optional.ofNullable(modelMapper.map(brandRepository.findById(id), BrandDto.class));
    }

    @Override
    public List<BrandDto> getAllBrands() {
        return brandRepository.findAll().stream().map((s) -> modelMapper.map(s, BrandDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<BrandDto> findBrandByName (String name) {
        return brandRepository.findAllByName(name).stream().map((s) -> modelMapper.map(s, BrandDto.class)).collect(Collectors.toList());
    }

    @Override
    public BrandDto updateBrand(BrandDto brand) {
        if(!this.validationUtil.isValid(brand)) {
            this.validationUtil
                    .violations(brand)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            throw new IllegalArgumentException("Illegal arguments in Brand for update!");
        }

        if (brandRepository.findById(brand.getId()).isPresent()) {
            return modelMapper.map(brandRepository.save(modelMapper.map(brand, Brand.class)), BrandDto.class);
        } else {
            throw new BrandNotFoundException(brand.getId());
        }
    }

    @Override
    public void deleteBrand(UUID id) {
        if (brandRepository.findById(id).isPresent()) {
            brandRepository.deleteById(id);
        } else {
            throw new BrandNotFoundException(id);
        }
    }
}
