package com.carparkingsystem.service.impl;

import com.carparkingsystem.dao.DTO.VehicleTrackingTimeDTO;
import com.carparkingsystem.dao.entity.VehicleTrackingTime;
import com.carparkingsystem.dao.repository.VehicleTrackingTimeRepository;
import com.carparkingsystem.service.VehicleTrackingTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class VehicleTrackingTimeServiceImpl implements VehicleTrackingTimeService {

    @Autowired
    private VehicleTrackingTimeRepository vehicleTrackingTimeRepository;

    @Override
    public List<Integer> getVehicleTrackingTimeIn(Date timeIn, Date timeOut) {
      List<Integer> trackingTimeList = vehicleTrackingTimeRepository.getVehicleTrackingTimeIn(timeIn, timeOut);
        return trackingTimeList;
    }

    @Override
    public List<Integer> getVehicleTrackingTimeOut(Date timeIn, Date timeOut) {
        List<Integer> trackingTimeList = vehicleTrackingTimeRepository.getVehicleTrackingTimeOut(timeIn, timeOut);
        return trackingTimeList;
    }
}
