package com.routaa.hospital.bl.room.repository.dao;

import com.routaa.hospital.entity.RoomEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomDao extends CrudRepository<RoomEntity, Integer> {
}
