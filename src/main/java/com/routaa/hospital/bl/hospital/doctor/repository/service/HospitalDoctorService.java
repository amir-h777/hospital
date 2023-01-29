package com.routaa.hospital.bl.hospital.doctor.repository.service;

import com.routaa.hospital.bl.hospital.doctor.model.HospitalDoctorDtoIn;
import com.routaa.hospital.bl.hospital.doctor.model.HospitalDoctorDtoOut;
import com.routaa.hospital.bl.hospital.doctor.repository.dao.HospitalDoctorDao;
import com.routaa.hospital.entity.HospitalDoctorEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class HospitalDoctorService {

    private final HospitalDoctorDao hospitalDoctorDao;
    private final ModelMapper modelMapper;

    @Autowired
    public HospitalDoctorService(HospitalDoctorDao hospitalDoctorDao, ModelMapper modelMapper){
        this.hospitalDoctorDao = hospitalDoctorDao;
        this.modelMapper = modelMapper;
    }

    public List<HospitalDoctorDtoOut> getAll(){
        Iterable<HospitalDoctorEntity> iterable = hospitalDoctorDao.findAll();
        List<HospitalDoctorDtoOut> hospitalDoctorDtoOuts = StreamSupport
                .stream(iterable.spliterator(), false)
                .map(HospitalDoctorDtoOut::new).collect(Collectors.toList());
        return hospitalDoctorDtoOuts;
    }

    public long count(){
        return hospitalDoctorDao.count();
    }

    public void deleteById(int hospitalId, int doctorId){
        hospitalDoctorDao.deleteByHospitalIdAndDoctorId(hospitalId, doctorId);
    }

    public HospitalDoctorDtoOut create(HospitalDoctorDtoIn hospitalDoctorDtoIn){
        HospitalDoctorEntity hospitalDoctorEntity = modelMapper.map(hospitalDoctorDtoIn, HospitalDoctorEntity.class);
        HospitalDoctorEntity save = hospitalDoctorDao.save(hospitalDoctorEntity);
        return new HospitalDoctorDtoOut(save);
    }

}
