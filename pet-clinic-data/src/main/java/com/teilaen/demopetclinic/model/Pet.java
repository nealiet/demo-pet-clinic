package com.teilaen.demopetclinic.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="pets")
public class Pet extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="type_id")
    private PetType petType;

    @Column(name="name")
    private Owner owner;

    @Column(name="birth_date")
    private LocalDate birthDate;

    @Column(name="pet_name")
    private String petName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="pet_id")
    private Set<Visit> visits= new HashSet<>();

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }
}
