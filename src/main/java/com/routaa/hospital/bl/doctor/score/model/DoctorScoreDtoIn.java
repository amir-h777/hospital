package com.routaa.hospital.bl.doctor.score.model;

import com.routaa.hospital.entity.DoctorScoreEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class DoctorScoreDtoIn {

    private int doctorId;
    private float score;

    public DoctorScoreDtoIn(DoctorScoreEntity entity){
        if(entity != null){
            this.score = entity.getScore();
            this.doctorId = entity.getDoctorId();
        }
    }

}
