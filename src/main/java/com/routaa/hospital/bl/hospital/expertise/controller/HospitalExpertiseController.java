package com.routaa.hospital.bl.hospital.expertise.controller;

import com.routaa.hospital.bl.hospital.expertise.repository.service.HospitalExpertiseService;
import com.routaa.hospital.bl.hospital.expertise.model.HospitalExpertiseDtoIn;
import com.routaa.hospital.bl.hospital.expertise.model.HospitalExpertiseDtoOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class HospitalExpertiseController {

    private final HospitalExpertiseService hospitalExpertiseService;

    @Autowired
    public HospitalExpertiseController(HospitalExpertiseService hospitalExpertiseService){
        this.hospitalExpertiseService = hospitalExpertiseService;
    }

    @RequestMapping(value = "/expertises-in-hospitals", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HospitalExpertiseDtoOut>> getAll(){
        List<HospitalExpertiseDtoOut> hospitalExpertiseDtoOuts = hospitalExpertiseService.getAll();
        return  new ResponseEntity<>(hospitalExpertiseDtoOuts, HttpStatus.OK);
    }

    @RequestMapping(value = "/expertises-in-hospitals/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> count(){
        long count = hospitalExpertiseService.count();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @RequestMapping(value = "/expertise-in-hospital", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HospitalExpertiseDtoOut> create(@Valid @RequestBody HospitalExpertiseDtoIn hospitalExpertiseDtoIn){
        HospitalExpertiseDtoOut hospitalExpertiseDtoOut = hospitalExpertiseService.create(hospitalExpertiseDtoIn);
        return new ResponseEntity<>(hospitalExpertiseDtoOut, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/expertise-in-hospital/{id}/{id1}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable("id") int id, @PathVariable("id1") int id1){
        hospitalExpertiseService.deleteById(id, id1);
        return new ResponseEntity<>("HospitalExpertise with id : " + id + "," + id1 + " has been deleted", HttpStatus.OK);
    }

}
