package com.routaa.hospital.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hospital_type")
@Getter
@Setter
public class HospitalTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pk")
    private int id;

    @OneToMany(mappedBy = "hospitalType", fetch = FetchType.LAZY)
    private Set<HospitalEntity> hospitals = new HashSet<>();

    @Column(name = "hospital_type_name")
    private String name;

    public void update(HospitalTypeEntity hospitalType){
        this.name = hospitalType.getName();
    }

}
