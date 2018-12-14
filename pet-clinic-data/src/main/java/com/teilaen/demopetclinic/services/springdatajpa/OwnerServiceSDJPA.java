package com.teilaen.demopetclinic.services.springdatajpa;

import com.teilaen.demopetclinic.model.Owner;
import com.teilaen.demopetclinic.repositories.OwnerRepository;
import com.teilaen.demopetclinic.repositories.PetRepository;
import com.teilaen.demopetclinic.repositories.PetTypeRepository;
import com.teilaen.demopetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
@Profile("springdatajpa")
public class OwnerServiceSDJPA implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerServiceSDJPA(OwnerRepository ownerRepository, PetRepository petRepository,
                             PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String name) {
        return ownerRepository.findByLastName(name);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        /* if (object !=null) {
            if (object.getPets().size()>0) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeRepository.save(pet.getPetType()));
                        }

                    } else {
                        throw new RuntimeException("Pet type is required");
                    }
                    if (pet.getId()==null) {
                        Pet savedPet = petRepository.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });

            } */
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
}
