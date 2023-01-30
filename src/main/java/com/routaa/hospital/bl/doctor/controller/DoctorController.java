package com.routaa.hospital.bl.doctor.controller;

import com.routaa.hospital.bl.doctor.model.DoctorDtoIn;
import com.routaa.hospital.bl.doctor.model.DoctorDtoOut;
import com.routaa.hospital.bl.doctor.repository.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//adding 29th change to featur3 branch

@RestController
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @RequestMapping(value = "/doctors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DoctorDtoOut>> getAll() {
        List<DoctorDtoOut> all = doctorService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    //getById---->id-->pathvariable
    @RequestMapping(value = "/doctor/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DoctorDtoOut> getById(@PathVariable("id") int id){
        DoctorDtoOut doctorDtoOut = doctorService.getById(id);
        return new ResponseEntity<>(doctorDtoOut, HttpStatus.OK);
    }

    //count
    @RequestMapping(value = "/doctors/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> count(){
        long count = doctorService.count();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    //create -->body
    @RequestMapping(value = "/doctor", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DoctorDtoOut> create(@Valid @RequestBody DoctorDtoIn doctorDtoIn){
        DoctorDtoOut doctorDtoOut = doctorService.create(doctorDtoIn);
        return new ResponseEntity<>(doctorDtoOut, HttpStatus.CREATED);
    }

    //update------>id-->pathvariable , --->body
    @RequestMapping(value = "/doctor/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DoctorDtoOut> update(@PathVariable("id") int id, @Valid @RequestBody DoctorDtoIn doctorDtoIn){
        DoctorDtoOut doctorDtoOut = doctorService.update(id, doctorDtoIn);
        return new ResponseEntity<>(doctorDtoOut, HttpStatus.OK);
    }

    //delete----id-->pathvariable
    @RequestMapping(value = "/doctor/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        doctorService.deleteById(id);
        return new ResponseEntity<>("doctor with id : " + id + " has been deleted", HttpStatus.OK);
    }
}
