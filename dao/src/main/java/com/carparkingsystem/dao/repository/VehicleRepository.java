package com.carparkingsystem.dao.repository;

import com.carparkingsystem.dao.entity.Customer;
import com.carparkingsystem.dao.entity.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends PagingAndSortingRepository<Vehicle, Long> {
    Vehicle findAllByLicensePlate(String licensePlate);
    List<Vehicle> findAllByDeletedIsFalse();
    Page<Vehicle> findAllByCustomerAndDeletedIsFalse(Customer customer, Pageable pageable);
    Page<Vehicle> findAllByCustomerAndDeletedIsFalseAndLicensePlateContaining(Customer customer,Pageable pageable,String licensePlate);
    Vehicle findByIdVehicle(Long idVehicle);
    Page<Vehicle> findAllByDeletedIsFalse(Pageable pageable);
}
