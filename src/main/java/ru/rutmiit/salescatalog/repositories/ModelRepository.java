package ru.rutmiit.salescatalog.repositories;

import ru.rutmiit.salescatalog.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
