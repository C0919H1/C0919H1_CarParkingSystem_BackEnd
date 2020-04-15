package com.carparkingsystem.service.impl;

import com.carparkingsystem.dao.entity.ParkingFloor;
import com.carparkingsystem.dao.entity.ParkingPosition;
import com.carparkingsystem.dao.repository.ParkingPositionRepository;
import com.carparkingsystem.service.ParkingPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingPositionServiceImpl implements ParkingPositionService {
    @Autowired
    ParkingPositionRepository parkingPositionRepository;


    @Override
    public ParkingPosition getAllParkingPositionById(Long idParkingPosition) {
        return parkingPositionRepository.findById(idParkingPosition).orElse(null);
    }

    @Override
    public List<ParkingPosition> getAllParkingPositionByFloor(ParkingFloor parkingFloor) {
        return parkingPositionRepository.findAllByParkingFloor(parkingFloor);
    }

    @Override
    public Page<ParkingPosition> pageFindAll(Pageable pageable) {
        Page<ParkingPosition> parkingPositions = parkingPositionRepository.findAll(pageable);
        return parkingPositions;
    }

    @Override
    public ParkingPosition getAllParkingPositionByName(String nameParkingPosition) {
        return parkingPositionRepository.findAllByNameOfPosition(nameParkingPosition);
    }

    @Override
    public Page<ParkingPosition> getAllParkingPositionByName(Pageable pageable, String nameParkingPosition) {
        return parkingPositionRepository.findAllByNameOfPositionContaining(pageable,nameParkingPosition);
    }

    @Override
    public Page<ParkingPosition> getAllParkingPositionByFloor(Pageable pageable, ParkingFloor parkingFloor) {
        Page<ParkingPosition> parkingPositions = parkingPositionRepository.findAllByParkingFloor(pageable,parkingFloor);
        return parkingPositions;
    }

    @Override
    public Page<ParkingPosition> getAllParkingPositionByFloorAndNameOfPosition(Pageable pageable, ParkingFloor parkingFloor, String nameParkingPosition) {
        return parkingPositionRepository.findAllByParkingFloorAndNameOfPositionContaining(pageable,parkingFloor,nameParkingPosition);
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

    @Override
    public void saveParkingPosition(ParkingPosition parkingPosition) {
        parkingPositionRepository.save(parkingPosition);
    }


}
