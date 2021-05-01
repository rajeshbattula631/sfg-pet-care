package com.example.sfgpetcare.services.sdjpa;

import com.example.sfgpetcare.model.Owner;
import com.example.sfgpetcare.repositories.OwnerRepository;
import com.example.sfgpetcare.repositories.PetRepository;
import com.example.sfgpetcare.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    public static final String LAST_NAME = "Smith";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerJpaService ownerJpaService;

    private Owner owner1;

    @BeforeEach
    void setUp() {
        owner1 = Owner.builder().id(1L).build();
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());
        when(ownerRepository.findAll()).thenReturn(owners);
        Set<Owner> returnowners=ownerJpaService.findAll();
        assertNotNull(returnowners);
        assertEquals(2,returnowners.size());
        //verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner1));
        Owner returnowner=ownerJpaService.findById(1L);
        assertNotNull(returnowner);
    }

    @Test
    void findNotFoundById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner returnowner=ownerJpaService.findById(1L);
        assertNull(returnowner);
    }

    @Test
    void save() {
        Owner savedOwner=Owner.builder().id(1L).build();
        when(ownerRepository.save(any())).thenReturn(owner1);
        Owner returnowner=ownerJpaService.save(savedOwner);
        assertNotNull(returnowner);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerJpaService.delete(owner1);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerJpaService.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        owner1 = Owner.builder().id(1L).lastName(LAST_NAME).build();
        when(ownerRepository.findByLastName(any())).thenReturn(owner1);
        Owner owner=ownerJpaService.findByLastName(LAST_NAME);
        System.out.println(owner.getLastName());
        assertEquals(LAST_NAME, owner.getLastName());
        verify(ownerRepository).findByLastName(any());
    }
}