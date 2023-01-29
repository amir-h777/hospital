package com.routaa.hospital.bl.room.repository.service;

import com.routaa.hospital.bl.room.model.RoomDtoIn;
import com.routaa.hospital.bl.room.model.RoomDtoOut;
import com.routaa.hospital.bl.room.repository.dao.RoomDao;
import com.routaa.hospital.entity.RoomEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RoomService {
    private final RoomDao roomDao;
    private final ModelMapper modelMapper;

    @Autowired
    public RoomService(RoomDao roomDao, ModelMapper modelMapper){
        this.roomDao = roomDao;
        this.modelMapper = modelMapper;
    }

    public List<RoomDtoOut> getAll(){
        Iterable<RoomEntity> iterable = roomDao.findAll();
        List<RoomDtoOut> roomDtoOuts = StreamSupport.stream(iterable.spliterator(), false)
                .map(RoomDtoOut::new).collect(Collectors.toList());
        return roomDtoOuts;
    }

    public RoomDtoOut getById(int id){
        RoomEntity roomEntity = roomDao.findById(id).get();
        return new RoomDtoOut(roomEntity);
    }

    public long count(){
        return roomDao.count();
    }

    public void deleteById(int id){
        roomDao.deleteById(id);
    }

    public RoomDtoOut update(int id, RoomDtoIn roomDtoIn){
        RoomEntity roomEntity = modelMapper.map(roomDtoIn, RoomEntity.class);
        RoomEntity roomEntity1 = roomDao.findById(id).get();
        roomEntity1.update(roomEntity);
        RoomEntity save = roomDao.save(roomEntity1);
        return new RoomDtoOut(save);
    }

    public RoomDtoOut create(RoomDtoIn roomDtoIn){
        RoomEntity roomEntity = modelMapper.map(roomDtoIn, RoomEntity.class);
        RoomEntity save = roomDao.save(roomEntity);
        return new RoomDtoOut(save);
    }
}
