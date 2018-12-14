package com.teilaen.demopetclinic.services.map;

import com.teilaen.demopetclinic.model.Owner;
import com.teilaen.demopetclinic.model.Pet;
import com.teilaen.demopetclinic.services.OwnerService;
import com.teilaen.demopetclinic.services.PetService;
import com.teilaen.demopetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public void delete(Owner object) {
        super.delete(object);

    }

    @Override
    public Owner save(Owner object) {
        if (object !=null) {
            if (object.getPets().size()>0) {
                object.getPets().forEach(pet -> {
                    if (pet.getId()==null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {

                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }

                    } else {
                        throw new RuntimeException("Pet type is required");
                    }

                });

            }
            return super.save(object);
          }   else {
            return null;
        }

    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String name) {
        return null;
    }
}
