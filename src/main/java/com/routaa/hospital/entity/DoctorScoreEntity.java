package com.routaa.hospital.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "doctor_score")
@Getter
@Setter
public class DoctorScoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pk")
    private int id;

    @Column(name = "doctor_id_fk")
    private int doctorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id_fk", insertable = false, updatable = false)
    private DoctorEntity doctor;

    @Column(name = "score")
    private float score;

    public void update(DoctorScoreEntity doctorScore){
        this.doctorId = doctorScore.getDoctorId();
        this.score = doctorScore.getScore();
    }

}
