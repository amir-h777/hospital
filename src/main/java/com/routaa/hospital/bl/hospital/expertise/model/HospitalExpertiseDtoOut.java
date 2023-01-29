package com.routaa.hospital.bl.hospital.expertise.model;

import com.routaa.hospital.entity.HospitalExpertiseEntity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class HospitalExpertiseDtoOut extends HospitalExpertiseDtoIn{

    public HospitalExpertiseDtoOut(HospitalExpertiseEntity entity){
        super(entity);
    }
}
