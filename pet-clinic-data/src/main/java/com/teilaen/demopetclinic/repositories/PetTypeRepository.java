package com.teilaen.demopetclinic.repositories;

import com.teilaen.demopetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
