package com.routaa.hospital.bl.expertise.model;

import com.routaa.hospital.entity.ExpertiseEntity;
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
public class ExpertiseDtoOut extends ExpertiseDtoIn {

    private int id;

    public ExpertiseDtoOut(ExpertiseEntity entity){
        super(entity);
        if(entity != null){
            this.id = entity.getId();
        }
    }

}
