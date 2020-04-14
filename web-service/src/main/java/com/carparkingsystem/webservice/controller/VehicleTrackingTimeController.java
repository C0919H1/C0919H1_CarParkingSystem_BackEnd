package com.carparkingsystem.webservice.controller;

import com.carparkingsystem.dao.entity.VehicleTrackingTime;
import com.carparkingsystem.service.VehicleTrackingTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VehicleTrackingTimeController {

    @Autowired
    private VehicleTrackingTimeService vehicleTrackingTimeService;

    @GetMapping("/tracking-time/in")
    public ResponseEntity<?> listTrackingTimeIn(@RequestParam(value = "timeIn", required = false) @DateTimeFormat(pattern="MM-dd-yyyy") Date timeIn,
                                                @RequestParam(value = "timeOut", required = false) @DateTimeFormat(pattern="MM-dd-yyyy") Date timeOut) throws ParseException {

        List<Integer> list= vehicleTrackingTimeService.getVehicleTrackingTimeIn(timeIn,timeOut);
        System.out.println(timeIn + " " + timeOut);
        for(Integer integer:list) {
            System.out.println(integer);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/tracking-time/out")
    public ResponseEntity<?> listTrackingTimeOut(@RequestParam(value = "timeIn", required = false) @DateTimeFormat(pattern="MM-dd-yyyy") Date timeIn,
                                                 @RequestParam(value = "timeOut", required = false) @DateTimeFormat(pattern="MM-dd-yyyy") Date timeOut) throws ParseException{
        List<Integer> list = vehicleTrackingTimeService.getVehicleTrackingTimeOut(timeIn,timeOut);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

}
