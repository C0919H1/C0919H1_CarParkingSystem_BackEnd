package com.carparkingsystem.service;

import com.carparkingsystem.dao.entity.ParkingPosition;

import java.util.List;


public interface ParkingPositionService {
     ParkingPosition getAllParkingPositionById(Long idParkingPosition);

    ParkingPosition getAllParkingPositionByName(String nameParkingPosition);

    List<ParkingPosition> getAllParkingPosition();

    List<ParkingPosition> findAllVipPosition(Long firstNumber, Long secondNumber);
    List<ParkingPosition> findAllNormalPosition(Long firstNumber, Long secondNumber);
    boolean setStatusPositionTrue(Long idPosition);
    boolean setStatusPositionFalse(Long idPosition);
}
