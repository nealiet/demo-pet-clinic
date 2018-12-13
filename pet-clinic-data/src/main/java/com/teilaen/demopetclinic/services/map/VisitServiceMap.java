package com.teilaen.demopetclinic.services.map;

import com.teilaen.demopetclinic.model.Visit;
import com.teilaen.demopetclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {


    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {

            super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {

                super.delete(object);
    }

    @Override
    public Visit save(Visit object)  {
       // if (object.getPet()==null || object.getPet().getId()==null) {
     //       throw new RuntimeException("Invalid Visit");
       // }
        return super.save(object);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
