package com.routaa.hospital.bl.hospital.section.controller;

import com.routaa.hospital.bl.hospital.section.repository.service.HospitalSectionService;
import com.routaa.hospital.bl.hospital.section.model.HospitalSectionDtoIn;
import com.routaa.hospital.bl.hospital.section.model.HospitalSectionDtoOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class HospitalSectionController {

    private final HospitalSectionService hospitalSectionService;

    @Autowired
    public HospitalSectionController(HospitalSectionService hospitalSectionService){
        this.hospitalSectionService = hospitalSectionService;
    }

    @RequestMapping(value = "/hospital-sections", method =  RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HospitalSectionDtoOut>> getAll(){
        List<HospitalSectionDtoOut> hospitalSectionDtoOuts = hospitalSectionService.getAll();
        return new ResponseEntity<>(hospitalSectionDtoOuts, HttpStatus.OK);
    }

    @RequestMapping(value = "/hospital-section/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HospitalSectionDtoOut> getById(@PathVariable("id") int id){
        HospitalSectionDtoOut hospitalSectionDtoOut = hospitalSectionService.getById(id);
        return new ResponseEntity<>(hospitalSectionDtoOut, HttpStatus.OK);
    }

    @RequestMapping(value = "/hospital-sections/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> count(){
        long count = hospitalSectionService.count();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @RequestMapping(value = "/hospital-section", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HospitalSectionDtoOut> create(@Valid @RequestBody HospitalSectionDtoIn hospitalSectionDtoIn){
        HospitalSectionDtoOut hospitalSectionDtoOut = hospitalSectionService.create(hospitalSectionDtoIn);
        return new ResponseEntity<>(hospitalSectionDtoOut, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/hospital-section/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HospitalSectionDtoOut> update(@PathVariable("id") int id, @Valid @RequestBody HospitalSectionDtoIn hospitalSectionDtoIn){
        HospitalSectionDtoOut hospitalSectionDtoOut = hospitalSectionService.update(id, hospitalSectionDtoIn);
        return new ResponseEntity<>(hospitalSectionDtoOut, HttpStatus.OK);
    }

    @RequestMapping(value = "/hospital-section/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        hospitalSectionService.deleteById(id);
        return new ResponseEntity<>("HospitalSection with id : " + id + " has been deleted", HttpStatus.OK);
    }

}
