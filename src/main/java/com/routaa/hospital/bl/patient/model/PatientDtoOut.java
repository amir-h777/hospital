package com.routaa.hospital.bl.patient.model;

import com.routaa.hospital.entity.PatientEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class PatientDtoOut extends PatientDtoIn{

    private int id;

    public PatientDtoOut(PatientEntity entity){
        super(entity);
        if(entity != null){
            this.id = entity.getId();
        }
    }

}
