package com.carparkingsystem.service.impl;

import com.carparkingsystem.dao.DTO.TicketDTO;
import com.carparkingsystem.dao.DTO.TicketDTO2;
import com.carparkingsystem.dao.DTO.TicketDTO3;
import com.carparkingsystem.dao.entity.ParkingPosition;
import com.carparkingsystem.dao.entity.Ticket;
import com.carparkingsystem.dao.entity.TicketType;
import com.carparkingsystem.dao.entity.Vehicle;
import com.carparkingsystem.dao.repository.ParkingPositionRepository;
import com.carparkingsystem.dao.repository.TicketRepository;
import com.carparkingsystem.dao.repository.TicketTypeRepository;
import com.carparkingsystem.dao.repository.VehicleRepository;
import com.carparkingsystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    private String startDate = "", endDate = "", ticketregistrationdate = "";
    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ParkingPositionRepository parkingPositionRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    TicketTypeRepository ticketTypeRepository;

    @Override
    public List<TicketDTO2> getAllTicketDTO() {
        List<Ticket> ticketList = ticketRepository.findAll();
        List<TicketDTO2> ticketDTOS = new ArrayList<>();
        for (Ticket ticket : ticketList) {
            startDate = ticket.getStartDate().getDate() + "/" + (ticket.getStartDate().getMonth() + 1) + "/" + (ticket.getStartDate().getYear() + 1900);
            endDate = ticket.getEndDate().getDate() + "/" + (ticket.getEndDate().getMonth() + 1) + "/" + (ticket.getEndDate().getYear() + 1900);
            ticketregistrationdate = ticket.getDayRegistration().getDate() + "/" + (ticket.getDayRegistration().getMonth() + 1) + "/" + (ticket.getDayRegistration().getYear() + 1900);
            TicketDTO2 ticketDTO2 = new TicketDTO2(ticket.getIdTicket(), startDate, endDate, ticketregistrationdate);
            ticketDTOS.add(ticketDTO2);
        }

        return ticketDTOS;
    }



    @Override
    public TicketDTO2 getTicketDTO(Long idTicket) {
        Ticket ticket = ticketRepository.findById(idTicket).orElse(null);
        if (ticket != null) {
            startDate = ticket.getStartDate().getDate() + "/" + (ticket.getStartDate().getMonth() + 1) + "/" + (ticket.getStartDate().getYear() + 1900);
            endDate = ticket.getEndDate().getDate() + "/" + (ticket.getEndDate().getMonth() + 1) + "/" + (ticket.getEndDate().getYear() + 1900);
            ticketregistrationdate = ticket.getDayRegistration().getDate() + "/" + (ticket.getDayRegistration().getMonth() + 1) + "/" + (ticket.getDayRegistration().getYear() + 1900);
            return new TicketDTO2(ticket.getIdTicket(), startDate, endDate, ticketregistrationdate);
        }
        return null;
    }

    @Override
    public Ticket getTicket(Long idTicket) {
        Ticket ticket = ticketRepository.findById(idTicket).orElse(null);
        return null;
    }

    @Override
    public List<TicketDTO> getAllTicket() {
        List<Ticket> ticketList = ticketRepository.findAllByDeletedIsFalse();
        List<TicketDTO> ticketDTOS = new ArrayList<>();
        for (Ticket ticket : ticketList) {
            TicketDTO ticketDTO = new TicketDTO(ticket.getIdTicket(), ticket.getVehicle().getLicensePlate(), ticket.getVehicle().getCustomer().getFullName(), ticket.getStartDate(), ticket.getEndDate(), ticket.getParkingPosition().getParkingFloor().getNameFloor(), ticket.getParkingPosition().getNameOfPosition(), ticket.getTicketType().getNameTicketType(), ticket.getTicketType().getCost());
            ticketDTOS.add(ticketDTO);
        }
        return ticketDTOS;
    }

    //    TicketType ticketType, Date startDate, Date endDate, Date dayRegistration, boolean deleted, Employee employee, ParkingPosition parkingPosition, Vehicle vehicle
    @Override
    public boolean createTicket(TicketDTO ticketDTO) {
        Date date = new Date();
        List<Ticket> ticketList = ticketRepository.findAllByDeletedIsFalse();
        for (Ticket ticket : ticketList) {
            if (ticketDTO.getIdVehicle().equals(ticket.getVehicle().getLicensePlate())) {
                return false;
            }
        }
        ParkingPosition parkingPosition = this.parkingPositionRepository.findAllByNameOfPosition(ticketDTO.getNameOfPosition());
        TicketType ticketType = this.ticketTypeRepository.findAllByNameTicketType(ticketDTO.getTicketType());
        Vehicle vehicle = this.vehicleRepository.findAllByLicensePlate(ticketDTO.getIdVehicle());
        Ticket ticket = new Ticket(
                ticketType,
                ticketDTO.getStartDate(),
                ticketDTO.getEndDate(),
                date,
                false,
                null,
                parkingPosition,
                vehicle
        );
        ticketRepository.save(ticket);
        return true;
    }

    //TicketType ticketType, Date startDate, Date endDate, Date dayRegistration, Integer idVehicle, boolean deleted, Employee employee, ParkingPosition parkingPosition, Vehicle vehicle
    @Override
    public boolean editTicket(Long id, TicketDTO ticketDTO) {
        Date date = new Date();
        Ticket ticket = ticketRepository.findByIdTicketAndDeletedIsFalse(id);
        List<Ticket> ticketList = ticketRepository.findAllByDeletedIsFalse();
        if (ticket != null) {
            for (Ticket ticket1 : ticketList) {
                if (ticket1.getVehicle().getLicensePlate().equals(ticketDTO.getIdVehicle())) {
                    return false;
                }
            }
            ParkingPosition parkingPosition = this.parkingPositionRepository.findAllByNameOfPosition(ticketDTO.getNameOfPosition());
            TicketType ticketType = this.ticketTypeRepository.findAllByNameTicketType(ticketDTO.getTicketType());
            Vehicle vehicle = this.vehicleRepository.findAllByLicensePlate(ticketDTO.getIdVehicle());
            ticket.setTicketType(ticketType);
            ticket.setStartDate(ticketDTO.getStartDate());
            ticket.setEndDate(ticketDTO.getEndDate());
            ticket.setDayRegistration(date);
            ticket.setDeleted(false);
            ticket.setParkingPosition(parkingPosition);
            ticket.setVehicle(vehicle);
            ticketRepository.save(ticket);
        }
        return true;
    }

    @Override
    public boolean deleteTicket(Long idTicket) {
        Ticket ticket = ticketRepository.findByIdTicketAndDeletedIsFalse(idTicket);
        if (ticket != null) {
            ticket.setDeleted(true);
            ticketRepository.save(ticket);
            return true;
        }
        return false;
    }

    @Override
    public TicketDTO findTicketById(Long idTicket) {
        Ticket ticket = ticketRepository.findByIdTicketAndDeletedIsFalse(idTicket);
        if (ticket!=null){
            return new TicketDTO(
                    ticket.getIdTicket(),
                    ticket.getVehicle().getLicensePlate(),
                    ticket.getVehicle().getCustomer().getFullName(),
                    ticket.getStartDate(),
                    ticket.getEndDate(),
                    ticket.getParkingPosition().getParkingFloor().getNameFloor(),
                    ticket.getParkingPosition().getNameOfPosition(),
                    ticket.getTicketType().getNameTicketType(),
                    ticket.getTicketType().getCost()
            );
        }
        return null;
    }

    @Override
    public TicketDTO3 findTicketByIdParkingPosition(Long idTicket) {
        Ticket ticket = ticketRepository.findAllByParkingPosition_IdParkingPositionAndDeletedIsFalse(idTicket);
        if (ticket!=null){
            return new TicketDTO3(
                    ticket.getIdTicket(),
                    ticket.getVehicle().getLicensePlate(),
                    ticket.getVehicle().getTypeOfVehicle(),
                    ticket.getVehicle().getCustomer().getFullName(),
                    ticket.getVehicle().getCustomer().getPhoneNumber(),
                    ticket.getVehicle().getCustomer().getEmail(),
                    ticket.getVehicle().getCustomer().getDateOfBirth(),
                    ticket.getStartDate(),
                    ticket.getEndDate(),
                    ticket.getParkingPosition().getParkingFloor().getNameFloor(),
                    ticket.getParkingPosition().getNameOfPosition(),
                    ticket.getTicketType().getNameTicketType(),
                    ticket.getTicketType().getCost()
            );
        }
        return null;
    }

    @Override
    public TicketDTO3 findTicketByIdAndDeleteIsFalse(Long idTicket) {
        Ticket ticket = ticketRepository.findByIdTicketAndDeletedIsFalse(idTicket);
        if (ticket!=null){
            return new TicketDTO3(
                    ticket.getIdTicket(),
                    ticket.getVehicle().getLicensePlate(),
                    ticket.getVehicle().getTypeOfVehicle(),
                    ticket.getVehicle().getCustomer().getFullName(),
                    ticket.getVehicle().getCustomer().getPhoneNumber(),
                    ticket.getVehicle().getCustomer().getEmail(),
                    ticket.getVehicle().getCustomer().getDateOfBirth(),
                    ticket.getStartDate(),
                    ticket.getEndDate(),
                    ticket.getParkingPosition().getParkingFloor().getNameFloor(),
                    ticket.getParkingPosition().getNameOfPosition(),
                    ticket.getTicketType().getNameTicketType(),
                    ticket.getTicketType().getCost()
            );
        }
        return null;
    }

    @Override
    public TicketDTO2 getTicketByVehicle(Vehicle vehicle) {
        Ticket ticket = ticketRepository.findByVehicle(vehicle);
        startDate = ticket.getStartDate().getDate() + "/" + (ticket.getStartDate().getMonth() + 1) + "/" + (ticket.getStartDate().getYear() + 1900);
        endDate = ticket.getEndDate().getDate() + "/" + (ticket.getEndDate().getMonth() + 1) + "/" + (ticket.getEndDate().getYear() + 1900);
        ticketregistrationdate = ticket.getDayRegistration().getDate() + "/" + (ticket.getDayRegistration().getMonth() + 1) + "/" + (ticket.getDayRegistration().getYear() + 1900);
        return new TicketDTO2(ticket.getIdTicket(), startDate, endDate, ticketregistrationdate);
    }

    public Page<TicketDTO> pageFindAll(Pageable pageable) {
        Page<Ticket> tickets = ticketRepository.findAllByDeletedIsFalse(pageable);
        Page<TicketDTO> ticketDTOS;
        ticketDTOS = tickets.map(ticket -> {
            TicketDTO ticketDTO = new TicketDTO();
            ticketDTO.setIdTicket(ticket.getIdTicket());
            ticketDTO.setFullName(ticket.getVehicle().getCustomer().getFullName());
            ticketDTO.setIdVehicle(ticket.getVehicle().getLicensePlate());
            ticketDTO.setStartDate(ticket.getStartDate());
            ticketDTO.setEndDate(ticket.getEndDate());
            ticketDTO.setNameOfPosition(ticket.getParkingPosition().getNameOfPosition());
            ticketDTO.setNameFloor(ticket.getParkingPosition().getParkingFloor().getNameFloor());
            ticketDTO.setTicketType(ticket.getTicketType().getNameTicketType());
            ticketDTO.setCost(ticket.getTicketType().getCost());
            return ticketDTO;
        });
        return ticketDTOS;
    }

    @Override
    public Page<TicketDTO> findAllByVehicleLicensePlateContaining(Pageable pageable, String licensePlate) {
        Page<Ticket> tickets = ticketRepository.findAllByDeletedIsFalseAndVehicleLicensePlateContaining(pageable, licensePlate);
        Page<TicketDTO> ticketDTOS;
        ticketDTOS = tickets.map(ticket -> {
            TicketDTO ticketDTO = new TicketDTO();
            ticketDTO.setIdTicket(ticket.getIdTicket());
            ticketDTO.setFullName(ticket.getVehicle().getCustomer().getFullName());
            ticketDTO.setIdVehicle(ticket.getVehicle().getLicensePlate());
            ticketDTO.setStartDate(ticket.getStartDate());
            ticketDTO.setEndDate(ticket.getEndDate());
            ticketDTO.setNameOfPosition(ticket.getParkingPosition().getNameOfPosition());
            ticketDTO.setNameFloor(ticket.getParkingPosition().getParkingFloor().getNameFloor());
            ticketDTO.setTicketType(ticket.getTicketType().getNameTicketType());
            ticketDTO.setCost(ticket.getTicketType().getCost());
            return ticketDTO;
        });
        return ticketDTOS;
    }
}
