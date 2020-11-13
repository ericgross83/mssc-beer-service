package com.springboot.brewerysecondattempt.service;

import com.springboot.brewerysecondattempt.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto createNewBeer(BeerDto beerDto);
    BeerDto getBeerById(UUID beerId);
    BeerDto getBeerByUPC(Long upc);
    void updateBeerDto(UUID beerId, BeerDto beerDto);
}
