package com.routaa.hospital.bl.hospital.section.doctor.model;

import com.routaa.hospital.entity.HospitalSectionDoctorEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class HospitalSectionDoctorDtoIn {

    private int hospitalSectionId;
    private int doctorId;

    public HospitalSectionDoctorDtoIn(HospitalSectionDoctorEntity entity){
        if(entity != null){
            this.doctorId = entity.getDoctorId();
            this.hospitalSectionId = entity.getHospitalSectionId();
        }
    }

}
