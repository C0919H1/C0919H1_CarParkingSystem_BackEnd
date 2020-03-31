package com.carparkingsystem.service.impl;

import com.carparkingsystem.dao.DTO.VehicleDTO;
import com.carparkingsystem.dao.entity.Customer;
import com.carparkingsystem.dao.entity.Ticket;
import com.carparkingsystem.dao.entity.Vehicle;
import com.carparkingsystem.dao.repository.CustomerRepository;
import com.carparkingsystem.dao.repository.TicketRepository;
import com.carparkingsystem.dao.repository.VehicleRepository;
import com.carparkingsystem.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class VehicleServiceImpl implements VehicleService {
    String endDate = "";
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private  CustomerRepository customerRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Page<VehicleDTO> findAllByCustomer(Customer customer, Pageable pageable) {
        Page<Vehicle> vehicleList = vehicleRepository.findAllByCustomerAndDeletedIsFalse(customer, pageable);
        Page<VehicleDTO> vehicleDTOS;
        vehicleDTOS = vehicleList.map(vehicle -> {
            Ticket ticket = ticketRepository.findByVehicle(vehicle);
            VehicleDTO vehicleDTO;
            if(ticket==null) {
                endDate="";
                 vehicleDTO = new VehicleDTO(vehicle.getIdVehicle(),vehicle.getTypeOfVehicle(),vehicle.getLicensePlate(),"","");
            } else {
                endDate = ticket.getEndDate().getDate() + "/" + (ticket.getEndDate().getMonth()+1) + "/" + (ticket.getEndDate().getYear()+1900);
                 vehicleDTO = new VehicleDTO(vehicle.getIdVehicle(),vehicle.getTypeOfVehicle(),vehicle.getLicensePlate(),endDate,ticket.getTicketType().getNameTicketType());
            }

            return vehicleDTO;
        });
        return vehicleDTOS;
    }

    @Override
    public void saveVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle getVehicle(Long idvehicle) {
        Vehicle vehicle = vehicleRepository.findByIdVehicle(idvehicle);
        return vehicle;
    }

    @Override

    public List<Vehicle> getAllVehicle() {
        return (List<Vehicle>) vehicleRepository.findAll();
    }
    public Vehicle getAllVehicleByLicensePlate(String licensePlate) {
        return vehicleRepository.findAllByLicensePlate(licensePlate);
    }

    @Override
    public Page<VehicleDTO> findAllLicensePlateContaining(Customer customer,Pageable pageable, String licensePlate) {
        Page<Vehicle> vehicles = vehicleRepository.findAllByCustomerAndDeletedIsFalseAndLicensePlateContaining(customer,pageable, licensePlate);
        Page<VehicleDTO> vehicleDTOS;
        vehicleDTOS = vehicles.map(vehicle -> {
            Ticket ticket = ticketRepository.findByVehicle(vehicle);
            VehicleDTO vehicleDTO;
            if(ticket==null) {
                vehicleDTO = new VehicleDTO(vehicle.getIdVehicle(),vehicle.getTypeOfVehicle(),vehicle.getLicensePlate(),"","");
            } else {
                endDate = ticket.getEndDate().getDate() + "/" + (ticket.getEndDate().getMonth()+1) + "/" + (ticket.getEndDate().getYear()+1900);
                vehicleDTO = new VehicleDTO(vehicle.getIdVehicle(),vehicle.getTypeOfVehicle(),vehicle.getLicensePlate(),endDate,ticket.getTicketType().getNameTicketType());
            }

            return vehicleDTO;
        });
        return vehicleDTOS;
    }

    @Override
    public void deleteVehicle(Vehicle vehicle) {
        vehicleRepository.delete(vehicle);
    }
}
