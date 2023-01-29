package com.routaa.hospital.entity.composite;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class HospitalDoctorId implements Serializable {
    private int hospitalId;
    private int doctorId;
}
