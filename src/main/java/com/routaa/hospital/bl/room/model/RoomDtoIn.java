package com.routaa.hospital.bl.room.model;

import com.routaa.hospital.entity.RoomEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class RoomDtoIn {

    private int hospitalId;
    private int hospitalSectionId;
    private int doctorId;
    @NotNull
    @Size(min = 0, max = 50)
    private String name;
    private int number;


    public RoomDtoIn(RoomEntity entity){
        this.name = entity.getName();
        this.number = entity.getNumber();
        this.hospitalId = entity.getHospitalId();
        this.hospitalSectionId = entity.getHospitalSectionId();
        this.doctorId = entity.getDoctorId();
    }
}
