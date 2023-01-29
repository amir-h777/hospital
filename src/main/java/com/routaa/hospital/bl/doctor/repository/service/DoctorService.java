package com.routaa.hospital.bl.doctor.repository.service;

import com.routaa.hospital.bl.doctor.model.DoctorDtoIn;
import com.routaa.hospital.bl.doctor.model.DoctorDtoOut;
import com.routaa.hospital.bl.doctor.repository.dao.DoctorDao;
import com.routaa.hospital.entity.DoctorEntity;
import com.routaa.hospital.entity.DoctorScoreEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DoctorService {

    private final DoctorDao doctorDao;

    private final ModelMapper modelMapper;

    @Autowired
    public DoctorService(DoctorDao doctorDao, ModelMapper modelMapper) {
        this.doctorDao = doctorDao;
        this.modelMapper = modelMapper;
    }


    //doctorOut
    //1-getall
    public List<DoctorDtoOut> getAll() {
        Iterable<DoctorEntity> iterable = doctorDao.findAll();
        List<DoctorDtoOut> doctorDtoOuts = StreamSupport.stream(iterable.spliterator(), false)
                .map(DoctorDtoOut::new).collect(Collectors.toList());
        return doctorDtoOuts;
    }

    //doctorOut
    //2-getbyid
    public DoctorDtoOut getById(int id){
        DoctorEntity doctorEntity = doctorDao.findById(id).get();
        return new DoctorDtoOut(doctorEntity);
    }

    //int
    //3-count
    public long count(){
        return doctorDao.count();
    }

    //void
    //4 delete
    public void deleteById(int id){
        doctorDao.deleteById(id);
    }

    //doctorOut
    //5 updateById
    public DoctorDtoOut update(int id, DoctorDtoIn doctorDtoIn){
        DoctorEntity doctorEntity = modelMapper.map(doctorDtoIn, DoctorEntity.class);
        DoctorEntity doctorEntity1 = doctorDao.findById(id).get();
        doctorEntity1.update(doctorEntity);
        DoctorEntity save = doctorDao.save(doctorEntity1);
        return new DoctorDtoOut(save);
    }

    //doctorOut
    //6 create
    public DoctorDtoOut create(DoctorDtoIn doctorDtoIn){
        DoctorEntity doctorEntity = modelMapper.map(doctorDtoIn, DoctorEntity.class);
        DoctorEntity save = doctorDao.save(doctorEntity);
        return new DoctorDtoOut(save);
    }

}