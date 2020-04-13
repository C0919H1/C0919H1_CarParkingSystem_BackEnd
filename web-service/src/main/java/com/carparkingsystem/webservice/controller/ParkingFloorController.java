package com.carparkingsystem.webservice.controller;

import com.carparkingsystem.dao.entity.ParkingFloor;
import com.carparkingsystem.service.ParkingFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ParkingFloorController {

    @Autowired
    ParkingFloorService parkingFloorService;

    @GetMapping("/floor")
    public ResponseEntity<?> getAllFloor(){
        List<ParkingFloor> parkingFloors = parkingFloorService.getAllParkingFloor();
        if(parkingFloors.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(parkingFloors, HttpStatus.OK);
    }
}
