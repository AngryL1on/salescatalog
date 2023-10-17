package ru.rutmiit.salescatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rutmiit.salescatalog.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
