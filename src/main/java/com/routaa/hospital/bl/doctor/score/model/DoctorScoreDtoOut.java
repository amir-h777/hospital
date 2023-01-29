package com.routaa.hospital.bl.doctor.score.model;

import com.routaa.hospital.entity.DoctorScoreEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DoctorScoreDtoOut extends DoctorScoreDtoIn {

    private int id;

    public DoctorScoreDtoOut(DoctorScoreEntity entity){
        super(entity);
        if(entity != null){
            this.id = entity.getId();
        }
    }

}
