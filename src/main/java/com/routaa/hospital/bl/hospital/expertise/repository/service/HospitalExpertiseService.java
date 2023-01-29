package com.routaa.hospital.bl.hospital.expertise.repository.service;

import com.routaa.hospital.bl.hospital.expertise.model.HospitalExpertiseDtoIn;
import com.routaa.hospital.bl.hospital.expertise.model.HospitalExpertiseDtoOut;
import com.routaa.hospital.bl.hospital.expertise.repository.dao.HospitalExpertiseDao;
import com.routaa.hospital.entity.HospitalExpertiseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class HospitalExpertiseService {

    private final HospitalExpertiseDao hospitalExpertiseDao;
    private final ModelMapper modelMapper;

    public HospitalExpertiseService(HospitalExpertiseDao hospitalExpertiseDao, ModelMapper modelMapper){
        this.hospitalExpertiseDao = hospitalExpertiseDao;
        this.modelMapper = modelMapper;
    }

    public List<HospitalExpertiseDtoOut> getAll(){
        Iterable<HospitalExpertiseEntity> iterable = hospitalExpertiseDao.findAll();
        List<HospitalExpertiseDtoOut> hospitalExpertiseDtoOuts = StreamSupport
                .stream(iterable.spliterator(), false).map(HospitalExpertiseDtoOut::new)
                .collect(Collectors.toList());
        return hospitalExpertiseDtoOuts;
    }

    public long count(){
        return hospitalExpertiseDao.count();
    }

    public void deleteById(int hospitalId, int expertiseId){
        hospitalExpertiseDao.deleteByHospitalIdAndExpertiseId(hospitalId, expertiseId);
    }

    public HospitalExpertiseDtoOut create(HospitalExpertiseDtoIn hospitalExpertiseDtoIn){
        HospitalExpertiseEntity hospitalExpertiseEntity = modelMapper.map(hospitalExpertiseDtoIn, HospitalExpertiseEntity.class);
        HospitalExpertiseEntity save = hospitalExpertiseDao.save(hospitalExpertiseEntity);
        return new HospitalExpertiseDtoOut(save);
    }

}
