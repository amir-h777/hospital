package com.routaa.hospital.bl.hospital.type.model;

import com.routaa.hospital.entity.HospitalTypeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HospitalTypeDtoOut extends HospitalTypeDtoIn{

    private int id;

    public HospitalTypeDtoOut(HospitalTypeEntity entity){
        super(entity);
        if(entity != null){
            this.id = entity.getId();
        }
    }

}
