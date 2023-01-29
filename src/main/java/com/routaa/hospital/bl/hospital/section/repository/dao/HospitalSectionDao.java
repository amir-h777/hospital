package com.routaa.hospital.bl.hospital.section.repository.dao;

import com.routaa.hospital.entity.HospitalSectionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalSectionDao extends CrudRepository<HospitalSectionEntity, Integer> {
}
