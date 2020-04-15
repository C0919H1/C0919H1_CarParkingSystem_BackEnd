package com.carparkingsystem.dao.repository;

import com.carparkingsystem.dao.entity.ParkingFloor;
import com.carparkingsystem.dao.entity.ParkingPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface ParkingPositionRepository extends JpaRepository<ParkingPosition,Long> {
//    ParkingPosition findAllByIdParkingPosition(Long idParkingPosition);
    ParkingPosition findAllByNameOfPosition(String nameParkingPosition);
    Page<ParkingPosition> findAllByNameOfPositionContaining(Pageable pageable,String nameParkingPosition);
    Page<ParkingPosition> findAllByParkingFloor(Pageable pageable, ParkingFloor parkingFloor);
    Page<ParkingPosition> findAllByParkingFloorAndNameOfPositionContaining(Pageable pageable, ParkingFloor parkingFloor, String nameParkingPosition);
    List<ParkingPosition> findAllByPositionStatusIsFalse();
    List<ParkingPosition> findAllByPositionStatusIsFalseAndIdParkingPositionBetween(Long first,Long second);
    ParkingPosition findAllByIdParkingPositionAndPositionStatusIsFalse(Long id);
    ParkingPosition findAllByIdParkingPositionAndPositionStatusIsTrue(Long id);
    List<ParkingPosition> findAllByParkingFloor(ParkingFloor parkingFloor);
}
