package com.carparkingsystem.service;

import com.carparkingsystem.dao.DTO.VehicleTrackingTimeDTO;
import com.carparkingsystem.dao.entity.VehicleTrackingTime;

import java.util.Date;
import java.util.List;

public interface VehicleTrackingTimeService {
    List<Integer> getVehicleTrackingTimeIn(Date timeIn, Date timeOut);

    List<Integer> getVehicleTrackingTimeOut(Date timeIn, Date timeOut);
}
