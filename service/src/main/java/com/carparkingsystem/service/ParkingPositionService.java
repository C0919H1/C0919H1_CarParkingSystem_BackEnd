package com.carparkingsystem.service;


import com.carparkingsystem.dao.DTO.ParkingPositionDTO;

import com.carparkingsystem.dao.entity.ParkingFloor;
import com.carparkingsystem.dao.entity.ParkingPosition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ParkingPositionService {
   ParkingPosition getParkingPositionById(Long id);
    List<ParkingPosition> getAllParkingPositionByFloor(ParkingFloor parkingFloor);


    Page<ParkingPositionDTO> pageFindAll(Pageable pageable);

    ParkingPosition getAllParkingPositionByName(String nameParkingPosition);

    Page<ParkingPositionDTO> getAllParkingPositionByName(Pageable pageable,String nameParkingPosition);

    Page<ParkingPositionDTO> getAllParkingPositionByFloor(Pageable pageable, ParkingFloor parkingFloor);

    Page<ParkingPositionDTO> getAllParkingPositionByFloorAndNameOfPosition(Pageable pageable, ParkingFloor parkingFloor, String nameParkingPosition);


    List<ParkingPosition> getAllParkingPosition();

    List<ParkingPosition> findAllVipPosition(Long firstNumber, Long secondNumber);

    List<ParkingPosition> findAllNormalPosition(Long firstNumber, Long secondNumber);

    boolean setStatusPositionTrue(Long idPosition);

    boolean setStatusPositionFalse(Long idPosition);
   void saveParkingPosition(ParkingPosition parkingPosition);
}
