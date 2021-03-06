package com.carparkingsystem.dao.repository;

import com.carparkingsystem.dao.DTO.ReveneDTO;
import com.carparkingsystem.dao.entity.Ticket;
import com.carparkingsystem.dao.entity.Vehicle;
import org.bouncycastle.jcajce.provider.digest.MD2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByDeletedIsFalse();

    Ticket findByIdTicketAndDeletedIsFalse(Long id);

    Ticket findAllByParkingPosition_IdParkingPositionAndDeletedIsFalse(Long id);

    Page<Ticket> findAllByDeletedIsFalse(Pageable pageable);

    Page<Ticket> findAllByDeletedIsFalseAndVehicleLicensePlateContaining(Pageable pageable, String licensePlate);

    Ticket findByVehicle(Vehicle vehicle);

    @Query(value = "SELECT YEAR(t.ticketregistrationdate) AS NAM, SUM(DATEDIFF(t.enddate, t.startdate)* tp.cost) AS DOANHTHU FROM ticket t, tickettype tp WHERE t.idtickettype = tp.idtickettype GROUP BY NAM ORDER BY NAM", nativeQuery = true)
    ArrayList getRevenue();
}
