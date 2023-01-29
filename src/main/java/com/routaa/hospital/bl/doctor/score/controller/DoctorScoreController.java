package com.routaa.hospital.bl.doctor.score.controller;

import com.routaa.hospital.bl.doctor.score.model.DoctorScoreDtoIn;
import com.routaa.hospital.bl.doctor.score.model.DoctorScoreDtoOut;
import com.routaa.hospital.bl.doctor.score.repository.service.DoctorScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DoctorScoreController {

    private final DoctorScoreService doctorScoreService;

    @Autowired
    public DoctorScoreController(DoctorScoreService doctorScoreService){
        this.doctorScoreService = doctorScoreService;
    }

    @RequestMapping(value = "/doctor-scores", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DoctorScoreDtoOut>> getAll(){
        List<DoctorScoreDtoOut> doctorScoreDtoOuts = doctorScoreService.getAll();
        return new ResponseEntity<>(doctorScoreDtoOuts, HttpStatus.OK);
    }

    @RequestMapping(value = "/doctor-score/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DoctorScoreDtoOut> getById(@PathVariable("id") int id){
        DoctorScoreDtoOut doctorScoreDtoOut = doctorScoreService.getById(id);
        return new ResponseEntity<>(doctorScoreDtoOut, HttpStatus.OK);
    }

    @RequestMapping(value = "/doctor-scores/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> count(){
        long count = doctorScoreService.count();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @RequestMapping(value = "/doctor-score", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DoctorScoreDtoOut> create(@Valid @RequestBody DoctorScoreDtoIn doctorScoreDtoIn){
        DoctorScoreDtoOut doctorScoreDtoOut = doctorScoreService.create(doctorScoreDtoIn);
        return new ResponseEntity<>(doctorScoreDtoOut, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/doctor-score/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DoctorScoreDtoOut> update(@PathVariable("id") int id, @Valid @RequestBody DoctorScoreDtoIn doctorScoreDtoIn){
        DoctorScoreDtoOut doctorScoreDtoOut = doctorScoreService.update(id, doctorScoreDtoIn);
        return new ResponseEntity<>(doctorScoreDtoOut, HttpStatus.OK);
    }
    @RequestMapping(value = "/doctor-score/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        doctorScoreService.deleteById(id);
        return new ResponseEntity<>("DoctorScore with id : " + id + " has been deleted", HttpStatus.OK);
    }
}
