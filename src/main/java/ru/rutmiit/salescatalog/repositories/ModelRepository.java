package ru.rutmiit.salescatalog.repositories;

import ru.rutmiit.salescatalog.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModelRepository extends JpaRepository<Model, UUID> {
}
