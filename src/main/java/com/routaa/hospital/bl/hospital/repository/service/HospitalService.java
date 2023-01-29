package com.routaa.hospital.bl.hospital.repository.service;

import com.routaa.hospital.bl.hospital.model.HospitalDtoIn;
import com.routaa.hospital.bl.hospital.model.HospitalDtoOut;
import com.routaa.hospital.bl.hospital.repository.dao.HospitalDao;
import com.routaa.hospital.entity.HospitalEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class HospitalService {

    private final HospitalDao hospitalDao;
    private final ModelMapper modelMapper;

    @Autowired
    public HospitalService(HospitalDao hospitalDao, ModelMapper modelMapper){
        this.hospitalDao = hospitalDao;
        this.modelMapper = modelMapper;
    }

    public List<HospitalDtoOut> getAll(){
        Iterable<HospitalEntity> iterable = hospitalDao.findAll();
        List<HospitalDtoOut> hospitalDtoOuts = StreamSupport.stream(iterable.spliterator(), false)
                .map(HospitalDtoOut::new).collect(Collectors.toList());
        return hospitalDtoOuts;
    }

    public HospitalDtoOut getById(int id){
        HospitalEntity hospitalEntity = hospitalDao.findById(id).get();
        return new HospitalDtoOut(hospitalEntity);
    }

    public long count(){
        return hospitalDao.count();
    }

    public void deleteById(int id){
        hospitalDao.deleteById(id);
    }

    public HospitalDtoOut update(int id, HospitalDtoIn hospitalDtoIn){
        HospitalEntity hospitalEntity = modelMapper.map(hospitalDtoIn, HospitalEntity.class);
        HospitalEntity hospitalEntity1 = hospitalDao.findById(id).get();
        hospitalEntity1.update(hospitalEntity);
        HospitalEntity save = hospitalDao.save(hospitalEntity1);
        return new HospitalDtoOut(save);
    }

    public HospitalDtoOut create(HospitalDtoIn hospitalDtoIn){
        HospitalEntity hospitalEntity = modelMapper.map(hospitalDtoIn, HospitalEntity.class);
        HospitalEntity save = hospitalDao.save(hospitalEntity);
        return new HospitalDtoOut(save);
    }
}
