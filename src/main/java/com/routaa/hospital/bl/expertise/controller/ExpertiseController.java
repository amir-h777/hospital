package com.routaa.hospital.bl.expertise.controller;

import com.routaa.hospital.bl.expertise.model.ExpertiseDtoIn;
import com.routaa.hospital.bl.expertise.model.ExpertiseDtoOut;
import com.routaa.hospital.bl.expertise.repository.service.ExpertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class ExpertiseController {


    private final ExpertiseService expertiseService;

    @Autowired
    public ExpertiseController(ExpertiseService expertiseService){
        this.expertiseService = expertiseService;
    }

    @RequestMapping(value = "/expertises", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ExpertiseDtoOut>> getAll(){
        List<ExpertiseDtoOut> expertiseDtoOuts = expertiseService.getAll();
        return new ResponseEntity<>(expertiseDtoOuts, HttpStatus.OK);
    }

    @RequestMapping(value = "/expertise/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExpertiseDtoOut> getById(@PathVariable("id") int id){
        ExpertiseDtoOut expertiseDtoOut = expertiseService.getById(id);
        return new ResponseEntity<>(expertiseDtoOut, HttpStatus.OK);
    }

    @RequestMapping(value = "/expertises/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> count(){
        long count = expertiseService.count();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @RequestMapping(value = "/expertise", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExpertiseDtoOut> create(@Valid @RequestBody ExpertiseDtoIn expertiseDtoIn){
        ExpertiseDtoOut expertiseDtoOut = expertiseService.create(expertiseDtoIn);
        return new ResponseEntity<>(expertiseDtoOut, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/expertise/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExpertiseDtoOut> update(@PathVariable("id") int id, @Valid @RequestBody ExpertiseDtoIn expertiseDtoIn){
        ExpertiseDtoOut expertiseDtoOut = expertiseService.update(id, expertiseDtoIn);
        return new ResponseEntity<>(expertiseDtoOut, HttpStatus.OK);
    }

    @RequestMapping(value = "/expertise/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        expertiseService.deleteById(id);
        return new ResponseEntity<>("Expertise with id : " + id + " has been deleted", HttpStatus.OK);
    }

}
