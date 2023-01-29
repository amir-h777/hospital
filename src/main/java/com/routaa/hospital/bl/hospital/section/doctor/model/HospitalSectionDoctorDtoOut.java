package com.routaa.hospital.bl.hospital.section.doctor.model;

import com.routaa.hospital.entity.HospitalSectionDoctorEntity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class HospitalSectionDoctorDtoOut extends  HospitalSectionDoctorDtoIn{

    public HospitalSectionDoctorDtoOut(HospitalSectionDoctorEntity entity){
        super(entity);
    }

}
