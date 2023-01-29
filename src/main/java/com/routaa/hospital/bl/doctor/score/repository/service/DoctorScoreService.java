package com.routaa.hospital.bl.doctor.score.repository.service;

import com.routaa.hospital.bl.doctor.score.model.DoctorScoreDtoIn;
import com.routaa.hospital.bl.doctor.score.model.DoctorScoreDtoOut;
import com.routaa.hospital.bl.doctor.score.repository.dao.DoctorScoreDao;
import com.routaa.hospital.entity.DoctorScoreEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DoctorScoreService {

    private final DoctorScoreDao doctorScoreDao;
    private final ModelMapper modelMapper;

    @Autowired
    public DoctorScoreService(DoctorScoreDao doctorScoreDao, ModelMapper modelMapper){
        this.doctorScoreDao = doctorScoreDao;
        this.modelMapper = modelMapper;
    }

    public List<DoctorScoreDtoOut> getAll(){
        Iterable<DoctorScoreEntity> iterable = doctorScoreDao.findAll();
        List<DoctorScoreDtoOut> doctorScoreDtoOuts = StreamSupport.stream(iterable.spliterator(), false)
                .map(DoctorScoreDtoOut::new).collect(Collectors.toList());
        return doctorScoreDtoOuts;
    }

    public DoctorScoreDtoOut getById(int id){
        DoctorScoreEntity doctorScoreEntity = doctorScoreDao.findById(id).get();
        return new DoctorScoreDtoOut(doctorScoreEntity);
    }

    public long count(){
        return doctorScoreDao.count();
    }

    public void deleteById(int id){
        doctorScoreDao.deleteById(id);
    }

    public DoctorScoreDtoOut update(int id, DoctorScoreDtoIn doctorScoreDtoIn){
        DoctorScoreEntity doctorScoreEntity = modelMapper.map(doctorScoreDtoIn, DoctorScoreEntity.class);
        DoctorScoreEntity doctorScoreEntity1 = doctorScoreDao.findById(id).get();
        doctorScoreEntity1.update(doctorScoreEntity);
        DoctorScoreEntity save = doctorScoreDao.save(doctorScoreEntity1);
        return new DoctorScoreDtoOut(save);
    }

    public DoctorScoreDtoOut create(DoctorScoreDtoIn doctorScoreDtoIn){
        DoctorScoreEntity doctorScoreEntity = modelMapper.map(doctorScoreDtoIn, DoctorScoreEntity.class);
        DoctorScoreEntity save = doctorScoreDao.save(doctorScoreEntity);
        return new DoctorScoreDtoOut(save);
    }

}
