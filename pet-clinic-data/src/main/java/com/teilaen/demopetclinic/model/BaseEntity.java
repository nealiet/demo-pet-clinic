package com.teilaen.demopetclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {



    // Hibernate recommends 'Box' types
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
