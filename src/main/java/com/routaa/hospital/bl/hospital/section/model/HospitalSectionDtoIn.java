package com.routaa.hospital.bl.hospital.section.model;

import com.routaa.hospital.entity.HospitalSectionEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class HospitalSectionDtoIn {

    private int hospitalId;
    private int expertiseId;
    @NotNull
    @Size(min = 0, max = 50)
    private String name;

    public HospitalSectionDtoIn(HospitalSectionEntity entity){
        if(entity != null){
            this.name = entity.getName();
            this.hospitalId = entity.getHospitalId();
            this.expertiseId = entity.getExpertiseId();
        }
    }

}
