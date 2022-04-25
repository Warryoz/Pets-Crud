package com.crud.pets.service;

import com.crud.pets.dto.PetDto;
import com.crud.pets.entity.Pet;
import com.crud.pets.exception.ResourceNotFoundException;
import com.crud.pets.repository.PetRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PetService {
    private final PetRepository petRepository;
    private final ModelMapper modelMapper;

    public List<PetDto> getAllPets(){
        return petRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public PetDto createPet(PetDto petDto){
        Pet pet = mapToEntity(petDto);
        return mapToDto(petRepository.save(pet));
    }

    public PetDto getPetById(Long id){
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pet", "Id", id));
        return mapToDto(pet);
    }

    public PetDto updatePet(PetDto petDto, Long id){
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pet", "Id", id));
        pet.setName(petDto.getName());
        pet.setBirthDate(petDto.getBirthDate());
        pet.setRace(petDto.getRace());
        pet.setHasVaccinesUpdated(petDto.getHasVaccinesUpdated());
        pet.setGender(petDto.getGender());
        petRepository.save(pet);
        return mapToDto(pet);
    }

    public String deletePet(Long id){
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pet", "Id", id));
        petRepository.delete(pet);
        return "Pet successfully deleted";
    }

    private PetDto mapToDto(Pet pet){
        return modelMapper.map(pet, PetDto.class);
    }

    private Pet mapToEntity(PetDto petDto){
        return modelMapper.map(petDto, Pet.class);
    }

}
