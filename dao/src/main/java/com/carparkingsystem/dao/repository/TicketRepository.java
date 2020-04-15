package com.carparkingsystem.dao.repository;

import com.carparkingsystem.dao.entity.Ticket;
import com.carparkingsystem.dao.entity.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {
    List<Ticket> findAllByDeletedIsFalse();
    Ticket findByIdTicketAndDeletedIsFalse(Long id);
    Ticket findAllByParkingPosition_IdParkingPositionAndDeletedIsFalse(Long id);
    Page<Ticket> findAllByDeletedIsFalse(Pageable pageable);
    Page<Ticket> findAllByDeletedIsFalseAndVehicleLicensePlateContaining(Pageable pageable,String licensePlate);
    Ticket findByVehicle(Vehicle vehicle);
}
