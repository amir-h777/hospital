package com.routaa.hospital.bl.hospital.expertise.model;

import com.routaa.hospital.entity.HospitalExpertiseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class HospitalExpertiseDtoIn {

    private int hospitalId;
    private int expertiseId;

    public HospitalExpertiseDtoIn(HospitalExpertiseEntity entity){
        if(entity != null){
            this.hospitalId = entity.getHospitalId();
            this.expertiseId = entity.getExpertiseId();
        }
    }

}
