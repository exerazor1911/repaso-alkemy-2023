package com.alkemy.icons.icons.controllers;

import com.alkemy.icons.icons.dtos.requests.CountryRequestDTO;
import com.alkemy.icons.icons.dtos.responses.CountryBasicResponseDTO;
import com.alkemy.icons.icons.dtos.responses.CountryResponseDTO;
import com.alkemy.icons.icons.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cities")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<CountryBasicResponseDTO> countries = countryService.getAllCountries();
        return ResponseEntity.ok().body(countries);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        countryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<?> save (@RequestBody CountryRequestDTO dto) {

        CountryResponseDTO savedCountry = countryService.save(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedCountry);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        CountryResponseDTO dto = countryService.getById(id);
        return ResponseEntity.ok().body(dto);
    }

}
