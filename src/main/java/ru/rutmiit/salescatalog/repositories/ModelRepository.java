package ru.rutmiit.salescatalog.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.rutmiit.salescatalog.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ModelRepository extends JpaRepository<Model, UUID> {
    List<Model> findAllByName(String name);

    @Query("SELECT m FROM Model m JOIN m.brand b WHERE b.name = :brandName")
    List<Model> findAllByBrandName(@Param("brandName") String brandName);
}
