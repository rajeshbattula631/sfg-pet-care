package com.example.sfgpetcare.services.map;

import com.example.sfgpetcare.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    final Long ownerId= 1L;
    final String lastName= "Smith";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(1,owners.size());
    }


    @Test
    void deleteById() {

        ownerServiceMap.deleteById(ownerId);
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void saveExistingId() {
        long id = 2L;
        Owner owner2= Owner.builder().id(id).build();
        Owner owner2Saved=ownerServiceMap.save(owner2);

        assertEquals(id, owner2Saved.getId());
    }
    @Test
    void saveNoId() {

        Owner owner2Saved=ownerServiceMap.save(Owner.builder().build());
        System.out.println(owner2Saved.getId());
      assertNotNull(owner2Saved);
      assertNotNull(owner2Saved.getId());
    }

    @Test
    void findById() {
        Owner owner=ownerServiceMap.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastName() {
       // Owner ownertest=ownerServiceMap.findByLastName(lastName);
        Owner ownertest=ownerServiceMap.findByLastName("foo");
        assertNull(ownertest);
        //assertNotNull(ownertest);
        //assertEquals(ownerId, ownertest.getId());
    }
}