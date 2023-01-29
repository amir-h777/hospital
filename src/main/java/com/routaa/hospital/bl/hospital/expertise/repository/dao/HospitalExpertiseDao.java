package com.routaa.hospital.bl.hospital.expertise.repository.dao;

import com.routaa.hospital.entity.HospitalExpertiseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HospitalExpertiseDao extends CrudRepository<HospitalExpertiseEntity, Integer> {
    Optional<HospitalExpertiseEntity> findByHospitalIdAndExpertiseId(int hospitalId, int expertiseId);
    void deleteByHospitalIdAndExpertiseId(int hospitalId, int expertiseId);
}
