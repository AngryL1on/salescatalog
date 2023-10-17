package ru.rutmiit.salescatalog.repositories;

import ru.rutmiit.salescatalog.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
