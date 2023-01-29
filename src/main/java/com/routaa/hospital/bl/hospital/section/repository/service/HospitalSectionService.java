package com.routaa.hospital.bl.hospital.section.repository.service;

import com.routaa.hospital.bl.hospital.section.model.HospitalSectionDtoIn;
import com.routaa.hospital.bl.hospital.section.model.HospitalSectionDtoOut;
import com.routaa.hospital.bl.hospital.section.repository.dao.HospitalSectionDao;
import com.routaa.hospital.entity.HospitalSectionEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class HospitalSectionService {
    private final HospitalSectionDao hospitalSectionDao;
    private final ModelMapper modelMapper;

    @Autowired
    public HospitalSectionService(HospitalSectionDao hospitalSectionDao, ModelMapper modelMapper){
        this.hospitalSectionDao = hospitalSectionDao;
        this.modelMapper  = modelMapper;
    }

    public List<HospitalSectionDtoOut> getAll(){
        Iterable<HospitalSectionEntity> iterable = hospitalSectionDao.findAll();
        List<HospitalSectionDtoOut> hospitalSectionDtoOuts = StreamSupport
                .stream(iterable.spliterator(), false).map(HospitalSectionDtoOut::new)
                .collect(Collectors.toList());
        return hospitalSectionDtoOuts;
    }

    public HospitalSectionDtoOut getById(int id){
        HospitalSectionEntity hospitalSectionEntity = hospitalSectionDao.findById(id).get();
        return new HospitalSectionDtoOut(hospitalSectionEntity);
    }

    public long count(){
        return hospitalSectionDao.count();
    }

    public void deleteById(int id){
        hospitalSectionDao.deleteById(id);
    }

    public HospitalSectionDtoOut update(int id, HospitalSectionDtoIn hospitalSectionDtoIn){
        HospitalSectionEntity hospitalSectionEntity = modelMapper.map(hospitalSectionDtoIn, HospitalSectionEntity.class);
        HospitalSectionEntity hospitalSectionEntity1 = hospitalSectionDao.findById(id).get();
        hospitalSectionEntity1.update(hospitalSectionEntity);
        HospitalSectionEntity save = hospitalSectionDao.save(hospitalSectionEntity1);
        return new HospitalSectionDtoOut(save);
    }

    public HospitalSectionDtoOut create(HospitalSectionDtoIn hospitalSectionDtoIn){
        HospitalSectionEntity hospitalSectionEntity = modelMapper.map(hospitalSectionDtoIn, HospitalSectionEntity.class);
        HospitalSectionEntity save = hospitalSectionDao.save(hospitalSectionEntity);
        return new HospitalSectionDtoOut(save);
    }

}
