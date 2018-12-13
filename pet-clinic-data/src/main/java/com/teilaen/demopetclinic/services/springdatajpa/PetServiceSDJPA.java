package com.teilaen.demopetclinic.services.springdatajpa;

import com.teilaen.demopetclinic.model.Pet;
import com.teilaen.demopetclinic.repositories.PetRepository;
import com.teilaen.demopetclinic.repositories.PetTypeRepository;
import com.teilaen.demopetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetServiceSDJPA implements PetService {
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public PetServiceSDJPA(PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}
