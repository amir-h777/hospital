package com.routaa.hospital.bl.patient.repository.dao;

import com.routaa.hospital.entity.PatientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDao extends CrudRepository<PatientEntity, Integer> {
}
