package com.carparkingsystem.dao.repository;

import com.carparkingsystem.dao.entity.ParkingPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingPositionRepository extends JpaRepository<ParkingPosition,Long> {
    ParkingPosition findAllByIdParkingPosition(Long idParkingPosition);
    ParkingPosition findAllByNameOfPosition(String nameParkingPosition);
    List<ParkingPosition> findAllByPositionStatusIsFalse();
    List<ParkingPosition> findAllByPositionStatusIsFalseAndIdParkingPositionBetween(Long first,Long second);
    ParkingPosition findAllByIdParkingPositionAndPositionStatusIsFalse(Long id);
    ParkingPosition findAllByIdParkingPositionAndPositionStatusIsTrue(Long id);
}
