package com.routaa.hospital.bl.hospital.type.repository.dao;

import com.routaa.hospital.entity.HospitalTypeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalTypeDao extends CrudRepository<HospitalTypeEntity, Integer> {
}
