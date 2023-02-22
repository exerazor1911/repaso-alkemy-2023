package com.alkemy.icons.icons.controllers;

import com.alkemy.icons.icons.dtos.responses.IconResponseDTO;
import com.alkemy.icons.icons.services.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("icons")
public class IconController {

    @Autowired
    private IconService iconService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<IconResponseDTO> icons = iconService.getAllIcons();
        return ResponseEntity.ok().body(icons);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        iconService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
