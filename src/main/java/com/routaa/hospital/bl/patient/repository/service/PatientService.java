package com.routaa.hospital.bl.patient.repository.service;

import com.routaa.hospital.bl.patient.model.PatientDtoIn;
import com.routaa.hospital.bl.patient.model.PatientDtoOut;
import com.routaa.hospital.bl.patient.repository.dao.PatientDao;
import com.routaa.hospital.entity.PatientEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PatientService {
    private final PatientDao patientDao;
    private final ModelMapper modelMapper;

    @Autowired
    public PatientService(PatientDao patientDao, ModelMapper modelMapper){
        this.patientDao = patientDao;
        this.modelMapper = modelMapper;
    }

    public List<PatientDtoOut> getAll(){
        Iterable<PatientEntity> iterable = patientDao.findAll();
        List<PatientDtoOut> patientDtoOuts = StreamSupport.stream(iterable.spliterator(), false)
                .map(PatientDtoOut::new).collect(Collectors.toList());
        return patientDtoOuts;
    }

    public PatientDtoOut getById(int id){
        PatientEntity patientEntity = patientDao.findById(id).get();
        return new PatientDtoOut(patientEntity);
    }

    public long count(){
        return patientDao.count();
    }

    public void deleteById(int id){
        patientDao.deleteById(id);
    }

    public PatientDtoOut update(int id, PatientDtoIn patientDtoIn){
        PatientEntity patientEntity = modelMapper.map(patientDtoIn, PatientEntity.class);
        PatientEntity patientEntity1 = patientDao.findById(id).get();
        patientEntity1.update(patientEntity);
        PatientEntity save = patientDao.save(patientEntity1);
        return new PatientDtoOut(save);
    }

    public PatientDtoOut create(PatientDtoIn patientDtoIn){
        PatientEntity patientEntity = modelMapper.map(patientDtoIn, PatientEntity.class);
        PatientEntity save = patientDao.save(patientEntity);
        return new PatientDtoOut(save);
    }

}
