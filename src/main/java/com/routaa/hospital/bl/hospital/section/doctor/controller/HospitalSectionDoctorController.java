package com.routaa.hospital.bl.hospital.section.doctor.controller;

import com.routaa.hospital.bl.hospital.section.doctor.repository.service.HospitalSectionDoctorService;
import com.routaa.hospital.bl.hospital.section.doctor.model.HospitalSectionDoctorDtoIn;
import com.routaa.hospital.bl.hospital.section.doctor.model.HospitalSectionDoctorDtoOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class HospitalSectionDoctorController {
    private final HospitalSectionDoctorService hospitalSectionDoctorService;
    
    @Autowired
    public HospitalSectionDoctorController(HospitalSectionDoctorService hospitalSectionDoctorService){
        this.hospitalSectionDoctorService = hospitalSectionDoctorService;
    }

    @RequestMapping(value = "/doctors-in-hospital-sections", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HospitalSectionDoctorDtoOut>> getAll(){
        List<HospitalSectionDoctorDtoOut> hospitalSectionDoctorDtoOuts = hospitalSectionDoctorService.getAll();
        return new ResponseEntity<>(hospitalSectionDoctorDtoOuts, HttpStatus.OK);
    }

    @RequestMapping(value = "/doctors-in-hospital-sections/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> count(){
        long count = hospitalSectionDoctorService.count();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @RequestMapping(value = "/doctor-in-hospital-section", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HospitalSectionDoctorDtoOut> create(@Valid @RequestBody HospitalSectionDoctorDtoIn hospitalSectionDoctorDtoIn){
        HospitalSectionDoctorDtoOut hospitalSectionDoctorDtoOut = hospitalSectionDoctorService.create(hospitalSectionDoctorDtoIn);
        return new ResponseEntity<>(hospitalSectionDoctorDtoOut, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/doctor-in-hospital-section/{id}/{id1}")
    public ResponseEntity<String> delete(@PathVariable("id") int id, @PathVariable("id1") int id1){
        hospitalSectionDoctorService.deleteById(id, id1);
        return new ResponseEntity<>("HospitalSectionDoctor with id : " + id + "," + id1 + " has been deleted", HttpStatus.OK);
    }

}
