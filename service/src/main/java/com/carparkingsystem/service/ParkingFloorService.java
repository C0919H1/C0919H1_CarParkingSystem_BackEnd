package com.carparkingsystem.service;

import com.carparkingsystem.dao.entity.ParkingFloor;


import java.util.List;

public interface ParkingFloorService {
    ParkingFloor getParkingFloor(int idFloor);
    List<ParkingFloor> getAllParkingFloor();
}
