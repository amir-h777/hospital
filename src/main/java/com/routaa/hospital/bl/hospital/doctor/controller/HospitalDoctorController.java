package com.routaa.hospital.bl.hospital.doctor.controller;

import com.routaa.hospital.bl.hospital.doctor.repository.service.HospitalDoctorService;
import com.routaa.hospital.bl.hospital.doctor.model.HospitalDoctorDtoIn;
import com.routaa.hospital.bl.hospital.doctor.model.HospitalDoctorDtoOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class HospitalDoctorController {

    private final HospitalDoctorService hospitalDoctorService;

    @Autowired
    public HospitalDoctorController(HospitalDoctorService hospitalDoctorService){
        this.hospitalDoctorService = hospitalDoctorService;
    }

    @RequestMapping(value = "/doctors-in-hospitals", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HospitalDoctorDtoOut>> getAll(){
        List<HospitalDoctorDtoOut> hospitalDoctorDtoOuts = hospitalDoctorService.getAll();
        return new ResponseEntity<>(hospitalDoctorDtoOuts, HttpStatus.OK);
    }

    @RequestMapping(value = "doctors-in-hospitals/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> count(){
        long count = hospitalDoctorService.count();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @RequestMapping(value = "/doctor-in-hospital", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HospitalDoctorDtoOut> create(@Valid @RequestBody HospitalDoctorDtoIn hospitalDoctorDtoIn){
        HospitalDoctorDtoOut hospitalDoctorDtoOut = hospitalDoctorService.create(hospitalDoctorDtoIn);
        return new ResponseEntity<>(hospitalDoctorDtoOut, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/doctor-in-hospital/{id}/{id1}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable("id") int id, @PathVariable("id1") int id1){
        hospitalDoctorService.deleteById(id, id1);
        return new ResponseEntity<>("HospitalDoctor with id : " + id + "," + id1 + " has been deleted", HttpStatus.OK);
    }

}
