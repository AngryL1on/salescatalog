package ru.rutmiit.salescatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rutmiit.salescatalog.entity.Brand;

import java.util.UUID;

public interface BrandRepository extends JpaRepository<Brand, UUID> {
}
