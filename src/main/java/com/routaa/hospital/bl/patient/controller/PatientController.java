package com.routaa.hospital.bl.patient.controller;

import com.routaa.hospital.bl.patient.model.PatientDtoIn;
import com.routaa.hospital.bl.patient.model.PatientDtoOut;
import com.routaa.hospital.bl.patient.repository.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @RequestMapping(value = "/patients", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PatientDtoOut>> getAll(){
        List<PatientDtoOut> patientDtoOuts = patientService.getAll();
        return new ResponseEntity<>(patientDtoOuts, HttpStatus.OK);
    }

    @RequestMapping(value = "/patient/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientDtoOut> getById(@PathVariable("id") int id){
        PatientDtoOut patientDtoOut = patientService.getById(id);
        return new ResponseEntity<>(patientDtoOut, HttpStatus.OK);
    }

    @RequestMapping(value = "/patients/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> count(){
        long count = patientService.count();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @RequestMapping(value = "/patient", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientDtoOut> create(@Valid @RequestBody PatientDtoIn patientDtoIn){
        PatientDtoOut patientDtoOut = patientService.create(patientDtoIn);
        return new ResponseEntity<>(patientDtoOut, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/patient/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientDtoOut> update(@PathVariable("id") int id, @Valid @RequestBody PatientDtoIn patientDtoIn){
        PatientDtoOut patientDtoOut = patientService.update(id, patientDtoIn);
        return new ResponseEntity<>(patientDtoOut, HttpStatus.OK);
    }

    @RequestMapping(value = "/patient/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        patientService.deleteById(id);
        return new ResponseEntity<>("Patient with id : " + id + " has been deleted", HttpStatus.OK);
    }

}
