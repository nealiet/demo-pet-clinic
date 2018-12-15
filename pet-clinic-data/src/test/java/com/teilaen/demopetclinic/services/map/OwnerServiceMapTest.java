package com.teilaen.demopetclinic.services.map;

import com.teilaen.demopetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    final Long ownerId=1L;
    final String lastName="Smith";
    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertEquals(1,ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void saveExistingId() {
        Owner owner2 = Owner.builder().id(ownerId).build();
        Owner savedOwner = ownerServiceMap.save(owner2);
        assertEquals(savedOwner.getId(),ownerId);
    }

    @Test
    void saveNoId() {
        Owner owner2 = Owner.builder().build();
        Owner savedOwner = ownerServiceMap.save(owner2);
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findById() {

        Owner owner = ownerServiceMap.findById(ownerId);
        assertEquals(ownerId,owner.getId());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerServiceMap.findByLastName(lastName);
        Owner owner2  = ownerServiceMap.findByLastName("foo");
        assertNotNull(owner);
        assertNull(owner2);
        assertEquals(lastName,owner.getLastName());
        assertEquals(ownerId,owner.getId());
    }

}