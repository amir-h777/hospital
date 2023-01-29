package com.routaa.hospital.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "room")
@Getter
@Setter
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pk")
    private int id;

    @Column(name = "hospital_id_fk")
    private int hospitalId;

    @Column(name = "hospital_section_id_fk")
    private int hospitalSectionId;

    @Column(name = "doctor_id_fk")
    private int doctorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id_fk", insertable = false, updatable = false)
    private HospitalEntity hospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_section_id_fk", insertable = false, updatable = false)
    private HospitalSectionEntity hospitalSection;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id_fk", insertable = false, updatable = false)
    private DoctorEntity doctor;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    private Set<PatientEntity> patients = new HashSet<>();

    @Column(name = "room_name")
    private String name;

    @Column(name = "room_number")
    private int number;

    public void update(RoomEntity room){
        this.hospitalId = room.getHospitalId();
        this.hospitalSectionId = room.getHospitalSectionId();
        this.doctorId = room.getDoctorId();
        this.name = room.getName();
        this.number = room.getNumber();
    }
}
