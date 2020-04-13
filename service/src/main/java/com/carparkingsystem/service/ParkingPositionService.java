package com.carparkingsystem.service;

import com.carparkingsystem.dao.entity.ParkingFloor;
import com.carparkingsystem.dao.entity.ParkingPosition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ParkingPositionService {
    ParkingPosition getAllParkingPositionById(Long idParkingPosition);

    Page<ParkingPosition> pageFindAll(Pageable pageable);

    ParkingPosition getAllParkingPositionByName(String nameParkingPosition);

    Page<ParkingPosition> getAllParkingPositionByName(Pageable pageable,String nameParkingPosition);

    Page<ParkingPosition> getAllParkingPositionByFloor(Pageable pageable, ParkingFloor parkingFloor);

    Page<ParkingPosition> getAllParkingPositionByFloorAndNameOfPosition(Pageable pageable, ParkingFloor parkingFloor, String nameParkingPosition);

    List<ParkingPosition> getAllParkingPosition();

    List<ParkingPosition> findAllVipPosition(Long firstNumber, Long secondNumber);

    List<ParkingPosition> findAllNormalPosition(Long firstNumber, Long secondNumber);

    boolean setStatusPositionTrue(Long idPosition);

    boolean setStatusPositionFalse(Long idPosition);
}
