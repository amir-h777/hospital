package com.routaa.hospital.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "hospital")
@Getter
@Setter
public class HospitalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pk")
    private int id;

    @Column(name = "hospital_type_id_fk")
    private int hospitalTypeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_type_id_fk", insertable = false, updatable = false)
    private HospitalTypeEntity hospitalType;

    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
    private Set<HospitalExpertiseEntity> hospitalExpertiseEntities = new HashSet<>();

    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
    private Set<HospitalSectionEntity> hospitalSections = new HashSet<>();

    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
    private Set<HospitalDoctorEntity> hospitalDoctorEntities = new HashSet<>();

    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
    private Set<RoomEntity> rooms = new HashSet<>();

    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
    private Set<PatientEntity> patients = new HashSet<>();

    @Column(name = "hospital_name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "ceo")
    private String ceo;

    public void update(HospitalEntity hospital){
        this.hospitalTypeId = hospital.getHospitalTypeId();
        this.name = hospital.getName();
        this.address = hospital.getAddress();
        this.ceo = hospital.getCeo();
    }

}
