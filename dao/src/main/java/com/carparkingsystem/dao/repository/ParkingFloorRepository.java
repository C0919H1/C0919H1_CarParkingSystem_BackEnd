package com.carparkingsystem.dao.repository;

import com.carparkingsystem.dao.entity.ParkingFloor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingFloorRepository extends JpaRepository<ParkingFloor,Long>{
    ParkingFloor findByIdParkingFloor(int idFloor);
}
