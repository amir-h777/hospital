package com.routaa.hospital.bl.hospital.section.model;

import com.routaa.hospital.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HospitalSectionDtoOut extends HospitalSectionDtoIn{

    private int id;

    public HospitalSectionDtoOut(HospitalSectionEntity entity){
        super(entity);
        if(entity != null){
            this.id = entity.getId();
        }
    }

}
