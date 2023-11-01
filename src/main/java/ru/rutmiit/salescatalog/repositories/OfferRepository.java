package ru.rutmiit.salescatalog.repositories;

import org.springframework.stereotype.Repository;
import ru.rutmiit.salescatalog.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OfferRepository extends JpaRepository<Offer, UUID> {
    List<Offer> findAllByYear (int year);
}
