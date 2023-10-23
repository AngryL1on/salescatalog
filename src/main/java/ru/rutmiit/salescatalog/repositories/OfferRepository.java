package ru.rutmiit.salescatalog.repositories;

import ru.rutmiit.salescatalog.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OfferRepository extends JpaRepository<Offer, UUID> {
}
