package com.routaa.hospital.bl.doctor.model;

import com.routaa.hospital.entity.DoctorEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class DoctorDtoIn {

    private int expertiseId;
    @NotNull
    @Size(min = 0, max = 50)
    private String firstName;
    @NotNull
    @Size(min = 0, max = 50)
    private String lastName;

    public DoctorDtoIn(DoctorEntity entity) {
        if (entity != null) {
            this.expertiseId = entity.getExpertiseId();
            this.firstName = entity.getFirstName();
            this.lastName = entity.getLastName();
        }
    }
}
