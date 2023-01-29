package com.routaa.hospital.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "expertise")
@Getter
@Setter
public class ExpertiseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pk")
    private int id;

    @OneToMany(mappedBy = "expertise", fetch = FetchType.LAZY)
    private Set<HospitalExpertiseEntity> hospitalExpertiseEntities = new HashSet<>();

    @OneToOne(mappedBy = "expertise", fetch = FetchType.LAZY)
    private HospitalSectionEntity hospitalSection;

    @OneToMany(mappedBy = "expertise", fetch = FetchType.LAZY)
    private Set<DoctorEntity> doctors = new HashSet<>();

    @Column(name = "expertise_name")
    private String name;

    public void update(ExpertiseEntity expertise){
        this.name = expertise.getName();
    }

}
