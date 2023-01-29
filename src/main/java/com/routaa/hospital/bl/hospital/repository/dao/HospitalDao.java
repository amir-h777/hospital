package com.routaa.hospital.bl.hospital.repository.dao;

import com.routaa.hospital.entity.HospitalEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalDao extends CrudRepository<HospitalEntity, Integer> {
}
