package com.carparkingsystem.service;

import com.carparkingsystem.dao.DTO.VehicleDTO;
import com.carparkingsystem.dao.entity.Customer;
import com.carparkingsystem.dao.entity.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getAllVehicle();
    Page<VehicleDTO> findAllByCustomer(Customer customer,Pageable pageable);
    void saveVehicle(Vehicle vehicle);
    Vehicle getVehicle(Long idvehicle);
    Vehicle getAllVehicleByLicensePlate(String licensePlate);
    Page<VehicleDTO> findAllLicensePlateContaining(Customer customer,Pageable pageable, String licensePlate);
    void deleteVehicle(Vehicle vehicle);
}
