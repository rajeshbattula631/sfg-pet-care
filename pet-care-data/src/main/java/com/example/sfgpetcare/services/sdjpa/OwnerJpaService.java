package com.example.sfgpetcare.services.sdjpa;

import com.example.sfgpetcare.model.Owner;
import com.example.sfgpetcare.repositories.OwnerRepository;
import com.example.sfgpetcare.repositories.PetRepository;
import com.example.sfgpetcare.repositories.PetTypeRepository;
import com.example.sfgpetcare.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
@Service
@Profile("springdatajpa")
public class OwnerJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerJpaService(OwnerRepository ownerRepository, PetRepository petRepository,
                           PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }


    @Override
    public Set<Owner> findAll() {
        return (Set<Owner>) ownerRepository.findAll();
    }

    @Override
    public Owner findById(Long aLong) {
        Optional<Owner> optionalOwner =ownerRepository.findById(aLong);
        return optionalOwner.orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
ownerRepository.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}
