package com.example.sfgpetcare.bootstrap;

import com.example.sfgpetcare.model.Owner;
import com.example.sfgpetcare.model.Pet;
import com.example.sfgpetcare.model.PetType;
import com.example.sfgpetcare.model.Vet;
import com.example.sfgpetcare.services.OwnerService;
import com.example.sfgpetcare.services.PetTypeService;
import com.example.sfgpetcare.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;

    private final VetService vetService;

    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");

        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");

        PetType savedCatPetType = petTypeService.save(cat);
        System.out.println("Loaded PetTypes....");

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1231231234");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("1231231234");

        Pet fionasCat = new Pet();
        fionasCat.setName("Just Cat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionasCat);
        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Rajesh");
        owner3.setLastName("Battula");
        owner3.setAddress("17-5-57/2");
        owner3.setCity("Godavarikhani");
        owner3.setTelephone("8479464949");

        Pet rodCat = new Pet();
        rodCat.setName("Jessy Cat");
        rodCat.setOwner(owner3);
        rodCat.setBirthDate(LocalDate.now());
        rodCat.setPetType(savedCatPetType);
        owner3.getPets().add(rodCat);

        ownerService.save(owner3);

        System.out.println("Loaded Owners....");
        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");


        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Rod");
        vet3.setLastName("Porter");
        vetService.save(vet3);

        System.out.println("Loaded Vets....");
    }
}
