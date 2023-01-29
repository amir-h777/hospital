package com.routaa.hospital.bl.room.model;

import com.routaa.hospital.entity.PatientEntity;
import com.routaa.hospital.entity.RoomEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class RoomDtoOut extends RoomDtoIn{

    private int id;

    public RoomDtoOut(RoomEntity entity){
        super(entity);
        if(entity != null){
            this.id = entity.getId();
        }
    }

}
