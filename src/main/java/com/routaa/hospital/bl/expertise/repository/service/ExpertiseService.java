package com.routaa.hospital.bl.expertise.repository.service;

import com.routaa.hospital.bl.expertise.model.ExpertiseDtoIn;
import com.routaa.hospital.bl.expertise.model.ExpertiseDtoOut;
import com.routaa.hospital.bl.expertise.repository.dao.ExpertiseDao;
import com.routaa.hospital.entity.ExpertiseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ExpertiseService {

    private final ExpertiseDao expertiseDao;
    private final ModelMapper modelMapper;

    @Autowired
    public ExpertiseService(ExpertiseDao expertiseDao, ModelMapper modelMapper){
        this.expertiseDao = expertiseDao;
        this.modelMapper = modelMapper;
    }

    public List<ExpertiseDtoOut> getAll(){
        Iterable<ExpertiseEntity> iterable = expertiseDao.findAll();
        List<ExpertiseDtoOut> expertiseDtoOuts = StreamSupport.stream(iterable.spliterator(), false)
                .map(ExpertiseDtoOut::new).collect(Collectors.toList());
        return expertiseDtoOuts;
    }

    public ExpertiseDtoOut getById(int id){
        ExpertiseEntity expertiseEntity = expertiseDao.findById(id).get();
        return new ExpertiseDtoOut(expertiseEntity);
    }

    public long count(){
        return expertiseDao.count();
    }

    public void deleteById(int id){
        expertiseDao.deleteById(id);
    }

    public ExpertiseDtoOut update(int id, ExpertiseDtoIn expertiseDtoIn){
        ExpertiseEntity expertiseEntity = modelMapper.map(expertiseDtoIn, ExpertiseEntity.class);
        ExpertiseEntity expertiseEntity1 = expertiseDao.findById(id).get();
        expertiseEntity1.update(expertiseEntity);
        ExpertiseEntity save = expertiseDao.save(expertiseEntity1);
        return new ExpertiseDtoOut(save);
    }

    public ExpertiseDtoOut create(ExpertiseDtoIn expertiseDtoIn){
        ExpertiseEntity expertiseEntity = modelMapper.map(expertiseDtoIn, ExpertiseEntity.class);
        ExpertiseEntity save = expertiseDao.save(expertiseEntity);
        return new ExpertiseDtoOut(save);
    }

}
