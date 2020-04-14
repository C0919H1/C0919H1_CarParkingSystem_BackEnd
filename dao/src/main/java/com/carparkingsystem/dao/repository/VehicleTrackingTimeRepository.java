package com.carparkingsystem.dao.repository;

import com.carparkingsystem.dao.entity.VehicleTrackingTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface VehicleTrackingTimeRepository extends JpaRepository<VehicleTrackingTime, Long> {

    @Query(value = "SELECT count(time_in) FROM vehicle_tracking_time WHERE (time_in BETWEEN ?1 AND ?2) GROUP BY time_in ORDER BY time_in", nativeQuery = true)
    List<Integer> getVehicleTrackingTimeIn(Date timeIn, Date timeOut);

    @Query(value = "SELECT count(time_out) FROM vehicle_tracking_time WHERE (time_out BETWEEN ?1 AND ?2) GROUP BY time_out ORDER BY time_out", nativeQuery = true)
    List<Integer> getVehicleTrackingTimeOut(Date timeIn, Date timeOut);
}
