package com.crud.pets.dto;

import com.crud.pets.entity.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PetDto {
    private Long id;
    private String name;
    private String race;
    private LocalDate birthDate;
    private Boolean hasVaccinesUpdated;
    private Gender gender;
}
