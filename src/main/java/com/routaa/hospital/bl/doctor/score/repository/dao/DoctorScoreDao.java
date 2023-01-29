package com.routaa.hospital.bl.doctor.score.repository.dao;

import com.routaa.hospital.entity.DoctorScoreEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorScoreDao extends CrudRepository<DoctorScoreEntity, Integer> {
}
