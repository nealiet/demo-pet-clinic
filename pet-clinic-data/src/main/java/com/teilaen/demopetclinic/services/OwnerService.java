package com.teilaen.demopetclinic.services;

import com.teilaen.demopetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLasName(String name);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
