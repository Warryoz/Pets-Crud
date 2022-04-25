package com.crud.pets.repository;

import com.crud.pets.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet,Long> {
}
