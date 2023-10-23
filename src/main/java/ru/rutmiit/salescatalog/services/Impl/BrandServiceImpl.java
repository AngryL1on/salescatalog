package ru.rutmiit.salescatalog.services.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rutmiit.salescatalog.dtos.BrandDto;
import ru.rutmiit.salescatalog.entity.Brand;
import ru.rutmiit.salescatalog.exception.BrandConflictException;
import ru.rutmiit.salescatalog.exception.BrandNotFoundException;
import ru.rutmiit.salescatalog.repositories.BrandRepository;
import ru.rutmiit.salescatalog.services.BrandService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService{
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public BrandDto register(BrandDto brand) {
        Brand b = modelMapper.map(brand, Brand.class);
        UUID brandId = b.getId();
        if (brandId == null || brandRepository.findById(brandId).isEmpty()) {
            return modelMapper.map(brandRepository.save(b), BrandDto.class);
        } else {
            throw new BrandConflictException("A brand with this id already exists");
        }
    }

    @Override
    public List<BrandDto> getAll() {
        return brandRepository.findAll().stream().map((s) -> modelMapper.map(s, BrandDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<BrandDto> get(UUID id) {
        return Optional.ofNullable(modelMapper.map(brandRepository.findById(id), BrandDto.class));
    }

    @Override
    public void delete(UUID id) {
        if (brandRepository.findById(id).isPresent()) {
            brandRepository.deleteById(id);
        } else {
            throw new BrandNotFoundException(id);
        }
    }

    @Override
    public BrandDto update(BrandDto brand) {
        if (brandRepository.findById(brand.getId()).isPresent()) {
            return modelMapper.map(brandRepository.save(modelMapper.map(brand, Brand.class)), BrandDto.class);
        } else {
            throw new BrandNotFoundException(brand.getId());
        }
    }
}
