package com.routaa.hospital.entity.composite;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class HospitalExpertiseId implements Serializable {
    private int hospitalId;
    private int expertiseId;
}
