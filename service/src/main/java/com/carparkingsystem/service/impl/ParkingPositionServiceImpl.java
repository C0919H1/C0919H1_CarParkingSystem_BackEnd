package com.carparkingsystem.service.impl;

import com.carparkingsystem.dao.entity.ParkingPosition;
import com.carparkingsystem.dao.repository.ParkingPositionRepository;
import com.carparkingsystem.service.ParkingPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingPositionServiceImpl implements ParkingPositionService {
    @Autowired
    ParkingPositionRepository parkingPositionRepository;


    @Override
    public ParkingPosition getAllParkingPositionById(Long idParkingPosition) {
        return parkingPositionRepository.findAllByIdParkingPosition(idParkingPosition);
    }

    @Override
    public ParkingPosition getAllParkingPositionByName(String nameParkingPosition) {
        return parkingPositionRepository.findAllByNameOfPosition(nameParkingPosition);
    }

    @Override
    public List<ParkingPosition> getAllParkingPosition() {
        return parkingPositionRepository.findAllByPositionStatusIsFalse();
    }

    @Override
    public List<ParkingPosition> findAllVipPosition(Long firstNumber, Long secondNumber) {
        return parkingPositionRepository.findAllByPositionStatusIsFalseAndIdParkingPositionBetween(firstNumber,secondNumber);
    }

    @Override
    public List<ParkingPosition> findAllNormalPosition(Long firstNumber, Long secondNumber) {
        return parkingPositionRepository.findAllByPositionStatusIsFalseAndIdParkingPositionBetween(firstNumber,secondNumber);
    }

    @Override
    public boolean setStatusPositionTrue(Long idPosition) {
        ParkingPosition parkingPosition = parkingPositionRepository.findAllByIdParkingPositionAndPositionStatusIsFalse(idPosition);
        if (parkingPosition != null){
            parkingPosition.setPositionStatus(true);
            parkingPositionRepository.save(parkingPosition);
            return true;
        }
        return false;
    }

    @Override
    public boolean setStatusPositionFalse(Long idPosition) {
        ParkingPosition parkingPosition = parkingPositionRepository.findAllByIdParkingPositionAndPositionStatusIsTrue(idPosition);
        if (parkingPosition != null){
            parkingPosition.setPositionStatus(false);
            parkingPositionRepository.save(parkingPosition);
            return true;
        }
        return false;
    }

}
