package com.teilaen.demopetclinic.bootstrap;

import com.teilaen.demopetclinic.model.*;
import com.teilaen.demopetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count= petTypeService.findAll().size();
        if (count==0)  loadData();
    }

    private void loadData() {
        System.out.println("----------------> Loading Data");
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);
        System.out.println("----------------> Done Loading Pet Types");
        Owner owner1= new Owner();
        owner1.setFirstName("George");
        owner1.setLastName("Smith");
        owner1.setAddress("2222 Maple Ave");
        owner1.setCity("Arlington");
        owner1.setTelephone("222-222-2222");


        Pet dog1 = new Pet();
        dog1.setPetType(savedDogType);
        dog1.setBirthDate(LocalDate.now());
        dog1.setPetName("Licorice");
        dog1.setOwner(owner1);

        owner1.getPets().add(dog1);
        ownerService.save(owner1);
        System.out.println("---------------->Loaded First Owner");

        Owner owner2= new Owner();
        owner2.builder()
                .address("2225 Maple Ave")
                .firstName("Jane")
                .lastName("Doe")
                .city("Arlington")
                .telephone("221-221-2221");

        Pet cat1 = new Pet();
        cat1.setPetType(savedCatType);
        cat1.setBirthDate(LocalDate.now());
        cat1.setPetName("Charlie");
        cat1.setOwner(owner2);
        owner2.getPets().add(cat1);
        ownerService.save(owner2);
        System.out.println("Loaded Second Owner");

        /**  Save Specialties....  **/

        Specialty s1 = new Specialty();
        s1.setDescription("Radiology");
        Specialty s2 = new Specialty();
        s2.setDescription("Dental");
        Specialty s3 = new Specialty();
        s3.setDescription("Surgery");

        specialtyService.save(s1);
        specialtyService.save(s2);
        specialtyService.save(s3);

        Vet vet1 = new Vet();
        vet1.setFirstName("Cindy");
        vet1.setLastName("Duerr");
        vet1.getSpecialties().add(s1);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mark");
        vet2.setLastName("Feaster");
        vet2.getSpecialties().add(s2);
        vet2.getSpecialties().add(s3);
        vetService.save(vet2);


        Visit v1 = new Visit();
        v1.setPet(dog1);
        v1.setDescription("Dog is sneezing");
        v1.setDate(LocalDate.now());
        visitService.save(v1);

        System.out.println("************ Loaded Data");
    }
}
