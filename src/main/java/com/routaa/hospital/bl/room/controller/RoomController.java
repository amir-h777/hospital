package com.routaa.hospital.bl.room.controller;

import com.routaa.hospital.bl.room.model.RoomDtoIn;
import com.routaa.hospital.bl.room.model.RoomDtoOut;
import com.routaa.hospital.bl.room.repository.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService){
        this.roomService = roomService;
    }

    @RequestMapping(value = "/rooms", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RoomDtoOut>> getAll(){
        List<RoomDtoOut> roomDtoOuts = roomService.getAll();
        return new ResponseEntity<>(roomDtoOuts, HttpStatus.OK);
    }

    @RequestMapping(value = "/room/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoomDtoOut> getById(@PathVariable("id") int id){
        RoomDtoOut roomDtoOut = roomService.getById(id);
        return new ResponseEntity<>(roomDtoOut, HttpStatus.OK);
    }

    @RequestMapping(value = "/rooms/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> count(){
        long count = roomService.count();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @RequestMapping(value = "/room", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoomDtoOut> create(@Valid @RequestBody RoomDtoIn roomDtoIn){
        RoomDtoOut roomDtoOut = roomService.create(roomDtoIn);
        return new ResponseEntity<>(roomDtoOut, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/room/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoomDtoOut> update(@PathVariable("id") int id, @Valid @RequestBody RoomDtoIn roomDtoIn){
        RoomDtoOut roomDtoOut = roomService.update(id, roomDtoIn);
        return new ResponseEntity<>(roomDtoOut, HttpStatus.OK);
    }

    @RequestMapping(value = "/room/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        roomService.deleteById(id);
        return new ResponseEntity<>("Room with id : " + id + " has been deleted", HttpStatus.OK);
    }

}
