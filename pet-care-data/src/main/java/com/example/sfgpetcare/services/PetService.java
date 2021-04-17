package com.example.sfgpetcare.services;

import com.example.sfgpetcare.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
