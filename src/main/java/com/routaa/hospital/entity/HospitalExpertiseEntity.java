package com.routaa.hospital.entity;

import com.routaa.hospital.entity.composite.HospitalDoctorId;
import com.routaa.hospital.entity.composite.HospitalExpertiseId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "expertise_in_hospital")
@Getter
@Setter
@IdClass(HospitalExpertiseId.class)
public class HospitalExpertiseEntity {
    @Id
    @Column(name = "hospital_id_fk")
    private int hospitalId;

    @Id
    @Column(name = "expertise_id_fk")
    private int expertiseId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id_fk", insertable = false, updatable = false)
    HospitalEntity hospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expertise_id_fk", insertable = false, updatable = false)
    ExpertiseEntity expertise;


}
