package com.routaa.hospital.bl.hospital.type.repository.service;

import com.routaa.hospital.bl.hospital.type.repository.dao.HospitalTypeDao;
import com.routaa.hospital.bl.hospital.type.model.HospitalTypeDtoIn;
import com.routaa.hospital.bl.hospital.type.model.HospitalTypeDtoOut;
import com.routaa.hospital.entity.HospitalTypeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class HospitalTypeService {

    private final HospitalTypeDao hospitalTypeDao;
    private final ModelMapper modelMapper;

    @Autowired
    public HospitalTypeService(HospitalTypeDao hospitalTypeDao, ModelMapper modelMapper){
        this.hospitalTypeDao = hospitalTypeDao;
        this.modelMapper = modelMapper;
    }

    public List<HospitalTypeDtoOut> getAll(){
        Iterable<HospitalTypeEntity> iterable = hospitalTypeDao.findAll();
        List<HospitalTypeDtoOut> hospitalTypeDtoOuts = StreamSupport
                .stream(iterable.spliterator(), false)
                .map(HospitalTypeDtoOut::new).collect(Collectors.toList());
        return hospitalTypeDtoOuts;
    }

    public HospitalTypeDtoOut getById(int id){
        HospitalTypeEntity hospitalTypeEntity = hospitalTypeDao.findById(id).get();
        return new HospitalTypeDtoOut(hospitalTypeEntity);
    }

    public long count(){
        return hospitalTypeDao.count();
    }

    public void deleteById(int id){
        hospitalTypeDao.deleteById(id);
    }

    public HospitalTypeDtoOut update(int id, HospitalTypeDtoIn hospitalTypeDtoIn){
        HospitalTypeEntity hospitalTypeEntity = modelMapper.map(hospitalTypeDtoIn, HospitalTypeEntity.class);
        HospitalTypeEntity hospitalTypeEntity1 = hospitalTypeDao.findById(id).get();
        hospitalTypeEntity1.update(hospitalTypeEntity);
        HospitalTypeEntity save = hospitalTypeDao.save(hospitalTypeEntity1);
        return new HospitalTypeDtoOut(save);
    }

    public HospitalTypeDtoOut create(HospitalTypeDtoIn hospitalTypeDtoIn){
        HospitalTypeEntity hospitalTypeEntity = modelMapper.map(hospitalTypeDtoIn, HospitalTypeEntity.class);
        HospitalTypeEntity save = hospitalTypeDao.save(hospitalTypeEntity);
        return new HospitalTypeDtoOut(save);
    }

}
