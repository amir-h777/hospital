package com.routaa.hospital.bl.hospital.type.controller;

import com.routaa.hospital.bl.hospital.type.model.HospitalTypeDtoIn;
import com.routaa.hospital.bl.hospital.type.model.HospitalTypeDtoOut;
import com.routaa.hospital.bl.hospital.type.repository.service.HospitalTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class HospitalTypeController {
    private final HospitalTypeService hospitalTypeService;

    @Autowired
    public HospitalTypeController(HospitalTypeService hospitalTypeService){
        this.hospitalTypeService = hospitalTypeService;
    }

    @RequestMapping(value = "/hospital-types", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HospitalTypeDtoOut>> getAll(){
        List<HospitalTypeDtoOut> hospitalTypeDtoOuts = hospitalTypeService.getAll();
        return new ResponseEntity<>(hospitalTypeDtoOuts, HttpStatus.OK);
    }

    @RequestMapping(value = "/hospital-type/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HospitalTypeDtoOut> getById(@PathVariable("id") int id){
        HospitalTypeDtoOut hospitalTypeDtoOut = hospitalTypeService.getById(id);
        return new ResponseEntity<>(hospitalTypeDtoOut, HttpStatus.OK);
    }

    @RequestMapping(value = "/hospital-types/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> count(){
        long count = hospitalTypeService.count();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @RequestMapping(value = "/hospital-type", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HospitalTypeDtoOut> create(@Valid @RequestBody HospitalTypeDtoIn hospitalTypeDtoIn){
        HospitalTypeDtoOut hospitalTypeDtoOut = hospitalTypeService.create(hospitalTypeDtoIn);
        return new ResponseEntity<>(hospitalTypeDtoOut, HttpStatus.CREATED);
    }

    @RequestMapping(value = "hospital-type/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HospitalTypeDtoOut> update(@PathVariable("id") int id, @Valid @RequestBody HospitalTypeDtoIn hospitalTypeDtoIn){
        HospitalTypeDtoOut hospitalTypeDtoOut = hospitalTypeService.update(id, hospitalTypeDtoIn);
        return new ResponseEntity<>(hospitalTypeDtoOut, HttpStatus.OK);
    }

    @RequestMapping(value = "/hospital-type/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        hospitalTypeService.deleteById(id);
        return new ResponseEntity<>("HospitalType with id : " + id + " has been deleted", HttpStatus.OK);
    }

}
