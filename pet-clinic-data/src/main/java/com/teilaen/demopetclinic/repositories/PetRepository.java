package com.teilaen.demopetclinic.repositories;

import com.teilaen.demopetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository  extends CrudRepository<Pet, Long> {
}
