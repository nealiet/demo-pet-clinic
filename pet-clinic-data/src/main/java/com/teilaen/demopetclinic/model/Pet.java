package com.teilaen.demopetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="pets")
public class Pet extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="type_id")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name="pet_id")
    private Owner owner;

    @Column(name="birth_date")
    private LocalDate birthDate;

    @Column(name="pet_name")
    private String petName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="pet_id")
    private Set<Visit> visits= new HashSet<>();

   }
