package com.routaa.hospital.entity;

import com.routaa.hospital.entity.composite.HospitalSectionDoctorId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "doctor_in_hospital_section")
@Getter
@Setter
@IdClass(HospitalSectionDoctorId.class)
public class HospitalSectionDoctorEntity {
    @Id
    @Column(name = "hospital_section_id_fk")
    private int hospitalSectionId;

    @Id
    @Column(name = "doctor_id_fk")
    private int doctorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id_fk", insertable = false, updatable = false)
    private DoctorEntity doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_section_id_fk", insertable = false, updatable = false)
    private HospitalSectionEntity hospitalSection;


}
