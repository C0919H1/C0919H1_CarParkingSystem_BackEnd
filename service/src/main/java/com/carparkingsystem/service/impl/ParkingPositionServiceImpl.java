package com.carparkingsystem.service.impl;


import com.carparkingsystem.dao.DTO.ParkingPositionDTO;

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
        return parkingPositionRepository.findAllByIdParkingPosition(idParkingPosition);
    }

    @Override

    public Page<ParkingPositionDTO> pageFindAll(Pageable pageable) {
        Page<ParkingPosition> parkingPositions = parkingPositionRepository.findAll(pageable);
        Page<ParkingPositionDTO> parkingPositionDTOS;
        parkingPositionDTOS = parkingPositions.map(parkingPosition -> {
            ParkingPositionDTO parkingPositionDTO;
            if(parkingPosition.isPositionStatus()){
                parkingPositionDTO = new ParkingPositionDTO(parkingPosition.getIdParkingPosition(),parkingPosition.getNameOfPosition(), "Đã đăng ký", parkingPosition.getParkingFloor().getIdParkingFloor());
            }else{
                parkingPositionDTO = new ParkingPositionDTO(parkingPosition.getIdParkingPosition(),parkingPosition.getNameOfPosition(), "Chưa đăng ký", parkingPosition.getParkingFloor().getIdParkingFloor());
            }
            return parkingPositionDTO;
        });
        return parkingPositionDTOS;

    }

    @Override
    public ParkingPosition getAllParkingPositionByName(String nameParkingPosition) {
        return parkingPositionRepository.findAllByNameOfPosition(nameParkingPosition);
    }

    @Override
    public Page<ParkingPositionDTO> getAllParkingPositionByName(Pageable pageable, String nameParkingPosition) {
        Page<ParkingPosition> parkingPositions = parkingPositionRepository.findAllByNameOfPositionContaining(pageable,nameParkingPosition);
        Page<ParkingPositionDTO> parkingPositionDTOS;
        parkingPositionDTOS = parkingPositions.map(parkingPosition -> {
            ParkingPositionDTO parkingPositionDTO;
            if(parkingPosition.isPositionStatus()){
                parkingPositionDTO = new ParkingPositionDTO(parkingPosition.getIdParkingPosition(),parkingPosition.getNameOfPosition(), "Đã đăng ký", parkingPosition.getParkingFloor().getIdParkingFloor());
            }else{
                parkingPositionDTO = new ParkingPositionDTO(parkingPosition.getIdParkingPosition(),parkingPosition.getNameOfPosition(), "Chưa đăng ký", parkingPosition.getParkingFloor().getIdParkingFloor());
            }
            return parkingPositionDTO;
        });
        return parkingPositionDTOS;
    }

    @Override
    public Page<ParkingPositionDTO> getAllParkingPositionByFloor(Pageable pageable, ParkingFloor parkingFloor) {
        Page<ParkingPosition> parkingPositions = parkingPositionRepository.findAllByParkingFloor(pageable,parkingFloor);
        Page<ParkingPositionDTO> parkingPositionDTOS;
        parkingPositionDTOS = parkingPositions.map(parkingPosition -> {
            ParkingPositionDTO parkingPositionDTO;
            if(parkingPosition.isPositionStatus()){
                parkingPositionDTO = new ParkingPositionDTO(parkingPosition.getIdParkingPosition(),parkingPosition.getNameOfPosition(), "Đã đăng ký", parkingPosition.getParkingFloor().getIdParkingFloor());
            }else{
                parkingPositionDTO = new ParkingPositionDTO(parkingPosition.getIdParkingPosition(),parkingPosition.getNameOfPosition(), "Chưa đăng ký", parkingPosition.getParkingFloor().getIdParkingFloor());
            }
            return parkingPositionDTO;
        });
        return parkingPositionDTOS;
    }

    @Override
    public Page<ParkingPositionDTO> getAllParkingPositionByFloorAndNameOfPosition(Pageable pageable, ParkingFloor parkingFloor, String nameParkingPosition) {
        Page<ParkingPosition> parkingPositions = parkingPositionRepository.findAllByParkingFloorAndNameOfPositionContaining(pageable,parkingFloor,nameParkingPosition);
        Page<ParkingPositionDTO> parkingPositionDTOS;
        parkingPositionDTOS = parkingPositions.map(parkingPosition -> {
            ParkingPositionDTO parkingPositionDTO;
            if(parkingPosition.isPositionStatus()){
                parkingPositionDTO = new ParkingPositionDTO(parkingPosition.getIdParkingPosition(),parkingPosition.getNameOfPosition(), "Đã đăng ký", parkingPosition.getParkingFloor().getIdParkingFloor());
            }else{
                parkingPositionDTO = new ParkingPositionDTO(parkingPosition.getIdParkingPosition(),parkingPosition.getNameOfPosition(), "Chưa đăng ký", parkingPosition.getParkingFloor().getIdParkingFloor());
            }
            return parkingPositionDTO;
        });
        return parkingPositionDTOS;
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
