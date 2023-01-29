package com.routaa.hospital.bl.hospital.type.model;

import com.routaa.hospital.entity.HospitalTypeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class HospitalTypeDtoIn {

    @NotNull
    @Size(min = 0, max = 50)
    private String name;

    public HospitalTypeDtoIn (HospitalTypeEntity entity){
        if(entity != null){
            this.name = entity.getName();
        }
    }
}
