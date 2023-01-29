package com.routaa.hospital.bl.expertise.model;

import com.routaa.hospital.entity.ExpertiseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class ExpertiseDtoIn {
    @NotNull
    @Size(min = 0, max = 50)
    private String name;

    public ExpertiseDtoIn(ExpertiseEntity entity){
        if(entity != null){
            this.name = entity.getName();
        }
    }

}
