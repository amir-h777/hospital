package com.routaa.hospital.entity;

import com.routaa.hospital.entity.composite.HospitalDoctorId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "doctor_in_hospital")
@IdClass(HospitalDoctorId.class)
public class HospitalDoctorEntity {
    @Id
    @Column(name = "hospital_id_fk")
    private int hospitalId;

    @Id
    @Column(name = "doctor_id_fk")
    private int doctorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id_fk", insertable = false, updatable = false)
    private HospitalEntity hospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id_fk", insertable = false, updatable = false)
    private DoctorEntity doctor;

}
