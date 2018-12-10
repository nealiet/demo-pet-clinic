package com.teilaen.demopetclinic.bootstrap;

import com.teilaen.demopetclinic.model.Owner;
import com.teilaen.demopetclinic.model.PetType;
import com.teilaen.demopetclinic.model.Vet;
import com.teilaen.demopetclinic.services.OwnerService;
import com.teilaen.demopetclinic.services.PetTypeService;
import com.teilaen.demopetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1= new Owner();
        owner1.setFirstName("George");
        owner1.setLastName("Smith");
        ownerService.save(owner1);

        Owner owner2= new Owner();
        owner2.setFirstName("Jane");
        owner2.setLastName("Doe");
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Cindy");
        vet1.setLastName("Duerr");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mark");
        vet2.setLastName("Feaster");
        vetService.save(vet2);

        System.out.println("************ Loaded Vets.");
    }
}
