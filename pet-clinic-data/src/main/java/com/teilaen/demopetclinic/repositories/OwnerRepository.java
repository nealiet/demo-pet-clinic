package com.teilaen.demopetclinic.repositories;

import com.teilaen.demopetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
