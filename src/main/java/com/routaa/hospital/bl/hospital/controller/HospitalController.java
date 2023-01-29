package com.routaa.hospital.bl.hospital.controller;

import com.routaa.hospital.bl.hospital.model.HospitalDtoIn;
import com.routaa.hospital.bl.hospital.model.HospitalDtoOut;
import com.routaa.hospital.bl.hospital.repository.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class HospitalController {

    private final HospitalService hospitalService;

    @Autowired
    public HospitalController(HospitalService hospitalService){
        this.hospitalService = hospitalService;
    }

    @RequestMapping(value = "/hospitals", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HospitalDtoOut>> getAll(){
        List<HospitalDtoOut> hospitalDtoOuts = hospitalService.getAll();
        return new ResponseEntity<>(hospitalDtoOuts, HttpStatus.OK);
    }

    @RequestMapping(value = "hospital/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HospitalDtoOut> getById(@PathVariable("id") int id){
        HospitalDtoOut hospitalDtoOut = hospitalService.getById(id);
        return new ResponseEntity<>(hospitalDtoOut, HttpStatus.OK);
    }

    @RequestMapping(value = "hospitals/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> count(){
        long count = hospitalService.count();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @RequestMapping(value = "/hospital", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HospitalDtoOut> create(@Valid @RequestBody HospitalDtoIn hospitalDtoIn){
        HospitalDtoOut hospitalDtoOut = hospitalService.create(hospitalDtoIn);
        return new ResponseEntity<>(hospitalDtoOut, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/hospital/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HospitalDtoOut> update(@PathVariable("id") int id, @Valid @RequestBody HospitalDtoIn hospitalDtoIn){
        HospitalDtoOut hospitalDtoOut = hospitalService.update(id, hospitalDtoIn);
        return new ResponseEntity<>(hospitalDtoOut, HttpStatus.OK);
    }

    @RequestMapping(value = "hospital/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        hospitalService.deleteById(id);
        return new ResponseEntity<>("Hospital with id : " + id + " has been deleted", HttpStatus.OK);
    }

}
