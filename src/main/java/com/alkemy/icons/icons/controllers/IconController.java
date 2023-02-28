package com.alkemy.icons.icons.controllers;

import com.alkemy.icons.icons.dtos.requests.IconRequestDTO;
import com.alkemy.icons.icons.dtos.responses.IconResponseDTO;
import com.alkemy.icons.icons.services.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("icons")
public class IconController {

    @Autowired
    private IconService iconService;

    /*@GetMapping
    public ResponseEntity<?> getAll() {
        List<IconResponseDTO> icons = iconService.getAllIcons();
        return ResponseEntity.ok().body(icons);
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        iconService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody IconRequestDTO dto) {
        IconResponseDTO savedIcon = iconService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedIcon);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody IconRequestDTO dto) {
        IconResponseDTO resultDto = iconService.update(id, dto);
        return ResponseEntity.ok().body(resultDto);
    }

    @GetMapping
    public ResponseEntity<List<?>> getDetailsByFilters (
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String date,
            @RequestParam(required = false) Set<Long> cities,
            @RequestParam(required = false, defaultValue = "ASC") String order
    ) {
        List<IconResponseDTO> dtos = iconService.getByFilters(name, date, cities, order);
        return ResponseEntity.ok().body(dtos);
    }

}
