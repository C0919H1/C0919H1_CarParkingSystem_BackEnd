package com.carparkingsystem.webservice.controller;

import com.carparkingsystem.dao.entity.ParkingPosition;
import com.carparkingsystem.service.ParkingFloorService;
import com.carparkingsystem.service.ParkingPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ParkingPositionController {

    @Autowired
    ParkingFloorService parkingFloorService;
    @Autowired
    ParkingPositionService parkingPositionService;

    @GetMapping(value = "/parkingposition", params = {"page", "size", "search"})
    public ResponseEntity<?> listAllCustomers(@RequestParam("page") int page,
                                              @RequestParam("size") int size,
                                              @RequestParam("search") String position) {
        List<ParkingPosition> parkingPositions = parkingPositionService.getAllParkingPosition();
        Page<ParkingPosition> parkingPositionPage;
        if (parkingPositions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            if (position.equals("")) {
                parkingPositionPage = parkingPositionService.pageFindAll(PageRequest.of(page, size));
            } else {
                parkingPositionPage = parkingPositionService.getAllParkingPositionByName(PageRequest.of(page, size), position);
            }
        }
        return new ResponseEntity<>(parkingPositionPage, HttpStatus.OK);
    }

    @GetMapping(value = "/parkingposition", params = {"page", "size", "search", "floor"})
    public ResponseEntity<?> listAllCustomers(@RequestParam("page") int page,
                                              @RequestParam("size") int size,
                                              @RequestParam("search") String position,
                                              @RequestParam("floor") int idFloor) {
        List<ParkingPosition> parkingPositions = parkingPositionService.getAllParkingPosition();
        Page<ParkingPosition> parkingPositionPage;
        if (parkingPositions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            if (position.equals("")) {
                parkingPositionPage = parkingPositionService.getAllParkingPositionByFloor(PageRequest.of(page, size), parkingFloorService.getParkingFloor(idFloor));
            } else {
                parkingPositionPage = parkingPositionService.getAllParkingPositionByFloorAndNameOfPosition(PageRequest.of(page, size), parkingFloorService.getParkingFloor(idFloor), position);
            }
        }
        return new ResponseEntity<>(parkingPositionPage, HttpStatus.OK);
    }

    @GetMapping("/parkingposition")
    public ResponseEntity<?> ticket() {
        List<ParkingPosition> parkingPosition = parkingPositionService.getAllParkingPosition();
        if (parkingPosition == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(parkingPosition, HttpStatus.OK);
    }

    @GetMapping("/parkingposition/vip")
    public ResponseEntity<?> getVipPosition() {
        int first = 1;
        int second = 2;
        Long firstNumber = (long) first;
        Long secondNumber = (long) second;
        List<ParkingPosition> parkingPositions = parkingPositionService.findAllVipPosition((long) 1, (long) 40);
        if (parkingPositions == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(parkingPositions, HttpStatus.OK);
    }

    @GetMapping("/parkingposition/normal")
    public ResponseEntity<?> getNormalPosition() {
        int first = 1;
        int second = 2;
        Long firstNumber = (long) first;
        Long secondNumber = (long) second;
        List<ParkingPosition> parkingPositions = parkingPositionService.findAllVipPosition((long) 41, (long) 80);
        if (parkingPositions == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(parkingPositions, HttpStatus.OK);
    }

    @GetMapping("/settrue/{idParkingPosition}")
    public ResponseEntity<?> setTrue(@PathVariable("idParkingPosition") Long id) {
        if (parkingPositionService.setStatusPositionTrue(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/setfalse/{idParkingPosition}")
    public ResponseEntity<?> setFalse(@PathVariable("idParkingPosition") Long id) {
        if (parkingPositionService.setStatusPositionFalse(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "", params = {"name"})
    public ResponseEntity<?> getAllCourse(@RequestParam("name") String namePosition) {
        ParkingPosition parkingPosition = parkingPositionService.getAllParkingPositionByName(namePosition);
        if (parkingPosition != null) {
            return new ResponseEntity<>(parkingPosition, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
