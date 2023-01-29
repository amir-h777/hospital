package com.routaa.hospital.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "doctor")
@Getter
@Setter
public class DoctorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pk")
    private int id;

    @Column(name = "expertise_id_fk")
    private int expertiseId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expertise_id_fk", insertable = false, updatable = false)
    private ExpertiseEntity expertise;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private Set<DoctorScoreEntity> doctorScores = new HashSet<>();

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private Set<HospitalDoctorEntity> hospitalDoctorEntities = new HashSet<>();

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private Set<HospitalSectionDoctorEntity> hospitalSectionDoctorEntities = new HashSet<>();

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private Set<RoomEntity> rooms = new HashSet<>();

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private Set<PatientEntity> patients = new HashSet<>();

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public void update(DoctorEntity doctor){
        this.expertiseId = doctor.getExpertiseId();
        this.firstName = doctor.getFirstName();
        this.lastName = doctor.getLastName();
    }

}
