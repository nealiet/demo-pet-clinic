package com.teilaen.demopetclinic.services;

import com.teilaen.demopetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String name);


}
