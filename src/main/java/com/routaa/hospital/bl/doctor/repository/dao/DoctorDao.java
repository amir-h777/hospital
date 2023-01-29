package com.routaa.hospital.bl.doctor.repository.dao;

import com.routaa.hospital.entity.DoctorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorDao extends CrudRepository<DoctorEntity, Integer> {
    DoctorEntity findAllByFirstName(String firstName);
}