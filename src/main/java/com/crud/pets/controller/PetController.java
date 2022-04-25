package com.crud.pets.controller;


import com.crud.pets.dto.PetDto;
import com.crud.pets.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pets")
@AllArgsConstructor
public class PetController {
    private final PetService petService;

    @GetMapping
    public List<PetDto> getAllPets(){
        return petService.getAllPets();
    }

    @PostMapping
    public ResponseEntity<PetDto> createPet(@RequestBody PetDto petDto){
        return new ResponseEntity(petService.createPet(petDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetDto> getPetById(@PathVariable Long id){
        return new ResponseEntity(petService.getPetById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetDto> updatePet(@RequestBody PetDto petDto, @PathVariable Long id){
        return new ResponseEntity(petService.updatePet(petDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deletePet(@PathVariable Long id){
        return petService.deletePet(id);
    }
}
