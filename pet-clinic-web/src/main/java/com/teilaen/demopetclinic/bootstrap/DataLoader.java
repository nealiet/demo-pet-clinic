package com.teilaen.demopetclinic.bootstrap;

import com.teilaen.demopetclinic.model.Owner;
import com.teilaen.demopetclinic.model.Vet;
import com.teilaen.demopetclinic.services.OwnerService;
import com.teilaen.demopetclinic.services.VetService;
import com.teilaen.demopetclinic.services.map.OwnerServiceMap;
import com.teilaen.demopetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader() {

        ownerService=new OwnerServiceMap();
        vetService = new VetServiceMap();

    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1= new Owner();
        owner1.setId(1L);
        owner1.setFirstName("George");
        owner1.setLastName("Smith");
        ownerService.save(owner1);

        Owner owner2= new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Jane");
        owner2.setLastName("Doe");
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Cindy");
        vet1.setLastName("Duerr");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Mark");
        vet2.setLastName("Feaster");
        vetService.save(vet2);

        System.out.println("************ Loaded Vets.");
    }
}