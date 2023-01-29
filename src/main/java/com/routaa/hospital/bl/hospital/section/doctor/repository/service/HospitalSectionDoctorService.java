package com.routaa.hospital.bl.hospital.section.doctor.repository.service;

import com.routaa.hospital.bl.hospital.section.doctor.model.HospitalSectionDoctorDtoIn;
import com.routaa.hospital.bl.hospital.section.doctor.model.HospitalSectionDoctorDtoOut;
import com.routaa.hospital.bl.hospital.section.doctor.repository.dao.HospitalSectionDoctorDao;
import com.routaa.hospital.entity.HospitalSectionDoctorEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class HospitalSectionDoctorService {

    private final HospitalSectionDoctorDao hospitalSectionDoctorDao;
    private final ModelMapper modelMapper;

    @Autowired
    public HospitalSectionDoctorService(HospitalSectionDoctorDao hospitalSectionDoctorDao, ModelMapper modelMapper){
        this.hospitalSectionDoctorDao = hospitalSectionDoctorDao;
        this.modelMapper = modelMapper;
    }

    public List<HospitalSectionDoctorDtoOut> getAll(){
        Iterable<HospitalSectionDoctorEntity> iterable = hospitalSectionDoctorDao.findAll();
        List<HospitalSectionDoctorDtoOut> hospitalSectionDoctorDtoOuts = StreamSupport
                .stream(iterable.spliterator(), false)
                .map(HospitalSectionDoctorDtoOut::new).collect(Collectors.toList());
        return hospitalSectionDoctorDtoOuts;
    }

    public long count(){
        return hospitalSectionDoctorDao.count();
    }

    public void deleteById(int hospitalSectionId, int doctorId){
        hospitalSectionDoctorDao
                .deleteByHospitalSectionIdAndDoctorId(hospitalSectionId, doctorId);
    }

    public HospitalSectionDoctorDtoOut create(HospitalSectionDoctorDtoIn hospitalSectionDoctorDtoIn){
        HospitalSectionDoctorEntity hospitalSectionDoctorEntity = modelMapper.map(hospitalSectionDoctorDtoIn, HospitalSectionDoctorEntity.class);
        HospitalSectionDoctorEntity save = hospitalSectionDoctorDao.save(hospitalSectionDoctorEntity);
        return new HospitalSectionDoctorDtoOut(save);
    }

}
