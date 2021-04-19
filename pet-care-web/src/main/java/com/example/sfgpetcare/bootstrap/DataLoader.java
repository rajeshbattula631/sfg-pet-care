package com.example.sfgpetcare.bootstrap;

import com.example.sfgpetcare.model.Owner;
import com.example.sfgpetcare.model.Vet;
import com.example.sfgpetcare.services.OwnerService;
import com.example.sfgpetcare.services.VetService;
import com.example.sfgpetcare.services.map.OwnerServiceMap;
import com.example.sfgpetcare.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;

    private final VetService vetService;
    public DataLoader() {
        ownerService = new OwnerServiceMap();

        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setId(1L);
        ownerService.save(owner1);
        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setId(2L);
        ownerService.save(owner2);
        System.out.println("Loaded Owners....");
        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.setId(1L);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.setId(2L);

        vetService.save(vet2);
        System.out.println("Loaded Vets....");
    }
}
