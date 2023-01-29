package com.routaa.hospital.bl.hospital.model;

import com.routaa.hospital.entity.HospitalEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class HospitalDtoIn {

    private int hospitalTypeId;
    @NotNull
    @Size(min = 0, max = 50)
    private String name;
    @NotNull
    @Size(min = 0, max = 50)
    private String address;
    @NotNull
    @Size(min = 0, max = 50)
    private String ceo;

    public HospitalDtoIn(HospitalEntity entity){
        if(entity != null){
            this.name = entity.getName();
            this.address = entity.getAddress();
            this.ceo = entity.getCeo();
            this.hospitalTypeId = entity.getHospitalTypeId();
        }
    }

}
