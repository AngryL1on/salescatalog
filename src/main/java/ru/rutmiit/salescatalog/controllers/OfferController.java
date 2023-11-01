package ru.rutmiit.salescatalog.controllers;

import org.springframework.web.bind.annotation.*;
import ru.rutmiit.salescatalog.exception.OfferNotFoundException;
import ru.rutmiit.salescatalog.services.OfferService;
import ru.rutmiit.salescatalog.services.dtos.OfferDto;

import java.util.UUID;

@RestController
//@RequestMapping("/offers")
public class OfferController {
    private final OfferService offerService;
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }
    @GetMapping("offers")
    Iterable<OfferDto> getAllOffers() {
        return offerService.getAllOffers();
    }
    @GetMapping("offer/{id}")
    OfferDto getOffer(@PathVariable UUID id) {
        return offerService.getOffer(id).orElseThrow(() -> new OfferNotFoundException(id));
    }
    @PostMapping("offer")
    OfferDto createOffer(@RequestBody OfferDto offer) {
        return offerService.addOffer(offer);
    }
    @DeleteMapping("offer/{id}")
    void deleteOffer(@PathVariable UUID id) {
        offerService.deleteOffer(id);
    }
    @PutMapping("offer")
    OfferDto updateOffer(@RequestBody OfferDto offer) {
        return offerService.updateOffer(offer);
    }
}
