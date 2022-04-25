package com.crud.pets.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String name;
    private String race;
    private LocalDate birthDate;
    private Boolean hasVaccinesUpdated;
    private Gender gender;
}
