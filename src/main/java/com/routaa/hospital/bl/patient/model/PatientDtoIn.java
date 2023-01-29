package com.routaa.hospital.bl.patient.model;

import com.routaa.hospital.entity.PatientEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class PatientDtoIn {

    private int hospitalId;
    private int hospitalSectionId;
    private int roomId;
    private int doctorId;
    @NotNull
    @Size(min = 0, max = 50)
    private String firstName;
    @NotNull
    @Size(min = 0, max = 50)
    private String lastName;
    @NotNull
    @Size(min = 0, max = 50)
    private String illness;

    public PatientDtoIn(PatientEntity entity){
        if(entity != null){
            this.firstName = entity.getFirstName();
            this.lastName = entity.getLastName();
            this.illness = entity.getIllness();
            this.hospitalId = entity.getHospitalId();
            this.hospitalSectionId = entity.getHospitalSectionId();
            this.roomId = entity.getRoomId();
            this.doctorId = entity.getDoctorId();
        }
    }

}
