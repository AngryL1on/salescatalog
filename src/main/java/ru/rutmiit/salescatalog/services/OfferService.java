package ru.rutmiit.salescatalog.services;

import org.springframework.stereotype.Service;
import ru.rutmiit.salescatalog.services.dtos.OfferDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface OfferService {
    OfferDto addOffer(OfferDto offer);

    Optional<OfferDto> getOffer(UUID id);

    List<OfferDto> getAllOffers();

    List<OfferDto> findOfferByYear(int year);

    OfferDto updateOffer(OfferDto offer);

    void deleteOffer(UUID id);
}
