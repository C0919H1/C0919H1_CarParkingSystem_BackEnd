package com.carparkingsystem.webservice.controller;

import com.carparkingsystem.dao.DTO.VehicleDTO;
import com.carparkingsystem.dao.entity.Ticket;
import com.carparkingsystem.dao.entity.Vehicle;
import com.carparkingsystem.service.CustomerService;
import com.carparkingsystem.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VehicleController {
    public Long idCustomerTemp;
    @Autowired
    CustomerService customerService;

    @Autowired
    VehicleService vehicleService;

    @GetMapping("/vehicles")
    public ResponseEntity<List<VehicleDTO>> listAllVehicle() {
        List<VehicleDTO> vehicles = vehicleService.getAllVehicle();
        if (vehicles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping(value = "/vehicles/{id}", params = {"page", "size", "search"})
    public ResponseEntity<?> listAllVehicle(@PathVariable Long id,
                                            @RequestParam("page") int page,
                                            @RequestParam("size") int size,
                                            @RequestParam("search") String licensePlate) {
        idCustomerTemp = id;
        List<VehicleDTO> vehicles = vehicleService.getAllVehicle();
        Page<VehicleDTO> vehicleDTOPage;
        if (vehicles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            if (licensePlate.equals("")) {
                vehicleDTOPage = vehicleService.findAllByCustomer(customerService.getCustomer(id),PageRequest.of(page, size));
            } else {
                vehicleDTOPage = vehicleService.findAllLicensePlateContaining(customerService.getCustomer(id),PageRequest.of(page, size), licensePlate);
            }
        }
        return new ResponseEntity<>(vehicleDTOPage, HttpStatus.OK);
    }

    @RequestMapping(value = "/vehicles", method = RequestMethod.POST)
    public ResponseEntity<?> createVehicle(@Valid @RequestBody VehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle();
        vehicle.setLicensePlate(vehicleDTO.getLicensePlate());
        vehicle.setTypeOfVehicle(vehicleDTO.getTypeOfVehicle());
        vehicle.setCustomer(customerService.getCustomer(vehicleDTO.getIdCustomer()));
        vehicle.setDeleted(false);
        vehicleService.saveVehicle(vehicle);
        Page<VehicleDTO> vehicleDTOList = vehicleService.findAllLicensePlateContaining(customerService.getCustomer(idCustomerTemp),PageRequest.of(0, 100), " ");
        for(VehicleDTO vehicleDTOTemp: vehicleDTOList){
            Vehicle vehicleTemp = new Vehicle();
            vehicleTemp.setIdVehicle(vehicleDTOTemp.getIdVehicle());
            vehicleService.deleteVehicle(vehicleTemp);
        }
        return new ResponseEntity<>(0, HttpStatus.CREATED);
    }
}
