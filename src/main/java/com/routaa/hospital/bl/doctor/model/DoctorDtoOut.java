package com.routaa.hospital.bl.doctor.model;

import com.routaa.hospital.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class DoctorDtoOut extends DoctorDtoIn {

    private int id;

    public DoctorDtoOut(DoctorEntity entity) {
        super(entity);
        if (entity != null) {
            this.id = entity.getId();
        }
    }
}