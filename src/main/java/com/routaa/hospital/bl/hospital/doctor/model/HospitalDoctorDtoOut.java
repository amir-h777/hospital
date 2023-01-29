package com.routaa.hospital.bl.hospital.doctor.model;

import com.routaa.hospital.entity.HospitalDoctorEntity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class HospitalDoctorDtoOut extends HospitalDoctorDtoIn{

    public HospitalDoctorDtoOut(HospitalDoctorEntity entity){
        super(entity);
    }

}
