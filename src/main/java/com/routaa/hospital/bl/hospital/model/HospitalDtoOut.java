package com.routaa.hospital.bl.hospital.model;

import com.routaa.hospital.entity.HospitalDoctorEntity;
import com.routaa.hospital.entity.HospitalEntity;
import com.routaa.hospital.entity.HospitalExpertiseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class HospitalDtoOut extends HospitalDtoIn{

    private int id;

    public HospitalDtoOut(HospitalEntity entity){
        super(entity);
        if(entity != null){
            this.id = entity.getId();
        }
    }

}
