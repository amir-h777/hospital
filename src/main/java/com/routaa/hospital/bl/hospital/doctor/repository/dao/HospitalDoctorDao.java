package com.routaa.hospital.bl.hospital.doctor.repository.dao;

import com.routaa.hospital.entity.HospitalDoctorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HospitalDoctorDao extends CrudRepository<HospitalDoctorEntity, Integer> {
        void deleteByHospitalIdAndDoctorId(int hospitalId, int doctorId);
}
