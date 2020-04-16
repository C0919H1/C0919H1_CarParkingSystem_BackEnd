package com.carparkingsystem.service;

import com.carparkingsystem.dao.DTO.TicketDTO;
import com.carparkingsystem.dao.DTO.TicketDTO2;
import com.carparkingsystem.dao.DTO.TicketDTO3;
import com.carparkingsystem.dao.entity.Ticket;
import com.carparkingsystem.dao.entity.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TicketService {
    List<TicketDTO2> getAllTicketDTO();
    TicketDTO2 getTicketDTO(Long idTicket);
    Ticket getTicket(Long idTicket);
    TicketDTO2 getTicketByVehicle(Vehicle vehicle);
    List<TicketDTO> getAllTicket();

    boolean createTicket(TicketDTO ticketDTO);

    boolean editTicket(Long id, TicketDTO ticketDTO);

    boolean deleteTicket(Long idTicket);

    TicketDTO findTicketById(Long idTicket);

    TicketDTO3 findTicketByIdParkingPosition(Long idTicket);
    TicketDTO3 findTicketByIdAndDeleteIsFalse(Long idTicket);

    Page<TicketDTO> pageFindAll(Pageable pageable);

    Page<TicketDTO> findAllByVehicleLicensePlateContaining(Pageable pageable, String licensePlate);
}
