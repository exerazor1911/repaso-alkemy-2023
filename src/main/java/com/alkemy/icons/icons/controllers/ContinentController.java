package com.alkemy.icons.icons.controllers;

import com.alkemy.icons.icons.dtos.requests.ContinentRequestDTO;
import com.alkemy.icons.icons.dtos.responses.ContinentResponseDTO;
import com.alkemy.icons.icons.services.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("continents")
public class ContinentController {
    @Autowired
    private ContinentService continentService;
    @PostMapping
    public ResponseEntity<?> save(@RequestBody ContinentRequestDTO continent) {

        ContinentResponseDTO savedContinent = continentService.save(continent);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedContinent);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<ContinentResponseDTO> continents = continentService.getAllContinents();
        return ResponseEntity.ok().body(continents);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        continentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
