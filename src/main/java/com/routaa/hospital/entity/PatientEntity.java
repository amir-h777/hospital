package com.routaa.hospital.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "patient")
@Getter
@Setter
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pk")
    private int id;

    @Column(name = "hospital_id_fk")
    private int hospitalId;

    @Column(name = "hospital_section_id_fk")
    private int hospitalSectionId;

    @Column(name = "room_id_fk")
    private int roomId;

    @Column(name = "doctor_id_fk")
    private int doctorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id_fk", insertable = false, updatable = false)
    private HospitalEntity hospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_section_id_fk", insertable = false, updatable = false)
    private HospitalSectionEntity hospitalSection;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id_fk", insertable = false, updatable = false)
    private RoomEntity room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id_fk", insertable = false, updatable = false)
    private DoctorEntity doctor;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "illness")
    private String illness;

    public void update(PatientEntity patient){
        this.hospitalId = patient.getHospitalId();
        this.hospitalSectionId = patient.getHospitalSectionId();
        this.roomId = patient.getRoomId();
        this.doctorId = patient.getDoctorId();
        this.firstName = patient.getFirstName();
        this.lastName = patient.getLastName();
        this.illness = patient.getIllness();
    }

}
