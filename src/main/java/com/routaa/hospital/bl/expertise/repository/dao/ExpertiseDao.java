package com.routaa.hospital.bl.expertise.repository.dao;

import com.routaa.hospital.entity.ExpertiseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertiseDao extends CrudRepository<ExpertiseEntity, Integer> {
}
