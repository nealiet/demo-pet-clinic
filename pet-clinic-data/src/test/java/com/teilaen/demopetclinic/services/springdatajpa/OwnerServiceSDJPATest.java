package com.teilaen.demopetclinic.services.springdatajpa;

import com.teilaen.demopetclinic.model.Owner;
import com.teilaen.demopetclinic.repositories.OwnerRepository;
import com.teilaen.demopetclinic.repositories.PetRepository;
import com.teilaen.demopetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class OwnerServiceSDJPATest {
    private final String LAST_NAME="Smith";
    private final Long OWNER_ID=1L;
    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerServiceSDJPA service;

    Owner returnOwner;


    @BeforeEach
    void setUp() {
        returnOwner=Owner.builder().id(OWNER_ID).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner smith = service.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME,smith.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(Owner.builder().id(1L).lastName("Smith").build());
        returnOwnersSet.add(Owner.builder().id(2L).lastName("Thompson").build());
        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = service.findAll();
        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        Owner owner=service.findById(OWNER_ID);
        assertNotNull(owner);
    }
    @Test
    void findIdNotfound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner=service.findById(OWNER_ID);
        assertNull(owner);
    }
    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(OWNER_ID).build();
        when(ownerRepository.save(any())).thenReturn(returnOwner);
        Owner savedOwner = service.save(ownerToSave);
        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());

    }

    @Test
    void delete() {
        service.delete(returnOwner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(OWNER_ID);
        verify(ownerRepository).deleteById((anyLong()));
    }
}