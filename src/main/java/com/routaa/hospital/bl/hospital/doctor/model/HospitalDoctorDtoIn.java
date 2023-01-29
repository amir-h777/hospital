package com.routaa.hospital.bl.hospital.doctor.model;

import com.routaa.hospital.entity.HospitalDoctorEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class HospitalDoctorDtoIn {

    private int hospitalId;
    private int doctorId;

    public HospitalDoctorDtoIn(HospitalDoctorEntity entity){
        if (entity != null) {
            this.hospitalId = entity.getHospitalId();
            this.doctorId = entity.getDoctorId();
        }
    }

}
