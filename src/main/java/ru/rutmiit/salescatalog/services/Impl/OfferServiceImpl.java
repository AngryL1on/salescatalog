package ru.rutmiit.salescatalog.services.Impl;

import jakarta.validation.ConstraintViolation;
import ru.rutmiit.salescatalog.services.dtos.OfferDto;
import ru.rutmiit.salescatalog.exception.OfferConflictException;
import ru.rutmiit.salescatalog.exception.OfferNotFoundException;
import ru.rutmiit.salescatalog.entity.Offer;
import ru.rutmiit.salescatalog.repositories.OfferRepository;
import ru.rutmiit.salescatalog.services.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rutmiit.salescatalog.util.ValidationUtil;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public OfferDto addOffer(OfferDto offer) {
        if(!this.validationUtil.isValid(offer)) {
            this.validationUtil
                    .violations(offer)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            throw new IllegalArgumentException("Illegal arguments in Offer!");
        }

        Offer o = modelMapper.map(offer, Offer.class);
        UUID offerId = o.getId();

        if (offerId == null || offerRepository.findById(offerId).isEmpty()) {
            return modelMapper.map(offerRepository.save(o), OfferDto.class);
        } else {
            throw new OfferConflictException("A offer with this id already exists");
        }
    }

    @Override
    public Optional<OfferDto> getOffer(UUID id) {
        return Optional.ofNullable(modelMapper.map(offerRepository.findById(id), OfferDto.class));
    }

    @Override
    public List<OfferDto> getAllOffers() {
        return offerRepository.findAll().stream().map((s) -> modelMapper.map(s, OfferDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<OfferDto> findOfferByYear(int year) {
        return offerRepository.findAllByYear(year).stream().map((s) -> modelMapper.map(s, OfferDto.class)).collect(Collectors.toList());
    }

    @Override
    public OfferDto updateOffer(OfferDto offer) {
        if(!this.validationUtil.isValid(offer)) {
            this.validationUtil
                    .violations(offer)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            throw new IllegalArgumentException("Illegal arguments in Offer for update!");
        }

        if (offerRepository.findById(offer.getId()).isPresent()) {
            return modelMapper.map(offerRepository.save(modelMapper.map(offer, Offer.class)), OfferDto.class);
        } else {
            throw new OfferNotFoundException(offer.getId());
        }
    }

    @Override
    public void deleteOffer(UUID id) {
        if (offerRepository.findById(id).isPresent()) {
            offerRepository.deleteById(id);
        } else {
            throw new OfferNotFoundException(id);
        }
    }
}
