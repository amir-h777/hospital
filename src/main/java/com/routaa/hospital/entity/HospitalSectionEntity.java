package com.routaa.hospital.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hospital_section")
@Getter
@Setter
public class HospitalSectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pk")
    private int id;

    @Column(name = "hospital_id_fk")
    private int hospitalId;

    @Column(name = "expertise_id_fk")
    private int expertiseId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id_fk", insertable = false, updatable = false)
    private HospitalEntity hospital;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expertise_id_fk", insertable = false, updatable = false)
    private ExpertiseEntity expertise;

    @OneToMany(mappedBy = "hospitalSection", fetch = FetchType.LAZY)
    private Set<HospitalSectionDoctorEntity> hospitalSectionDoctorEntities = new HashSet<>();

    @OneToMany(mappedBy = "hospitalSection", fetch = FetchType.LAZY)
    private Set<RoomEntity> rooms = new HashSet<>();

    @OneToMany(mappedBy = "hospitalSection", fetch = FetchType.LAZY)
    private Set<PatientEntity> patients = new HashSet<>();

    @Column(name = "hospital_section_name")
    private String name;

    public void update(HospitalSectionEntity hospitalSection){
        this.hospitalId = hospitalSection.getHospitalId();
        this.expertiseId = hospitalSection.getExpertiseId();
        this.name = hospitalSection.getName();
    }

}