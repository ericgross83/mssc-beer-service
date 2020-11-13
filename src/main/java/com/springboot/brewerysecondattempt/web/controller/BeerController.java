package com.springboot.brewerysecondattempt.web.controller;

import com.springboot.brewerysecondattempt.service.BeerService;
import com.springboot.brewerysecondattempt.web.model.BeerDto;
import com.sun.net.httpserver.Headers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("api/v1/beer/")
@RestController
public class BeerController {

    private BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId) {
        BeerDto beer = beerService.getBeerById(beerId);
        return new ResponseEntity<>(beer, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createNewBeer(@RequestBody BeerDto beerDto) {
        BeerDto newBeer = beerService.createNewBeer(beerDto);
        Headers headers = new Headers();
        headers.add("Location", "api/v1/beer/" + newBeer.getId());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBeer(@PathVariable UUID beerId, @RequestBody BeerDto beerDto){
        beerService.updateBeerDto(beerId, beerDto);
    }

}
