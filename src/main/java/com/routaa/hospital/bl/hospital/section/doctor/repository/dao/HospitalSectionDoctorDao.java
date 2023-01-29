package com.routaa.hospital.bl.hospital.section.doctor.repository.dao;

import com.routaa.hospital.entity.HospitalSectionDoctorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HospitalSectionDoctorDao extends CrudRepository<HospitalSectionDoctorEntity, Integer> {
    Optional<HospitalSectionDoctorEntity> findByHospitalSectionIdAndDoctorId(int hospitalSectionId, int doctorId);
    void deleteByHospitalSectionIdAndDoctorId(int hospitalSectionId, int doctorId);
}
