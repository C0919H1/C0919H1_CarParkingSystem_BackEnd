package com.carparkingsystem.service.impl;

import com.carparkingsystem.dao.entity.ParkingFloor;
import com.carparkingsystem.dao.repository.ParkingFloorRepository;
import com.carparkingsystem.service.ParkingFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingFloorServiceImpl implements ParkingFloorService {

    @Autowired
    ParkingFloorRepository parkingFloorRepository;
    @Override
    public ParkingFloor getParkingFloor(int idFloor) {
        return parkingFloorRepository.findByIdParkingFloor(idFloor);
    }

    @Override
    public List<ParkingFloor> getAllParkingFloor() {
        return parkingFloorRepository.findAll();
    }
}
