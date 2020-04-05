package com.carparkingsystem.webservice.controller;

import com.carparkingsystem.dao.DTO.TicketDTO;

import com.carparkingsystem.dao.DTO.TicketDTO2;

import com.carparkingsystem.service.TicketService;
import com.carparkingsystem.service.TicketTypeService;
import com.carparkingsystem.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @Autowired
    TicketTypeService ticketTypeService;

    @Autowired
    VehicleService vehicleService;

    @GetMapping("/tickets")
    public ResponseEntity<?> listAllTicket(){
        List<TicketDTO2> ticketDTOS = ticketService.getAllTicketDTO();
        if (ticketDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticketDTOS, HttpStatus.OK);
    }

    @GetMapping("/tickets/{id}")
    public ResponseEntity<?> ticket(@PathVariable Long id){
        TicketDTO2 ticketDTO2 = ticketService.getTicketByVehicle(vehicleService.getVehicle(id));
        if (ticketDTO2 == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticketDTO2, HttpStatus.OK);
    }

    @GetMapping(value = "", params = {"page", "size", "search"})
    public ResponseEntity<?> getAllCourse(@RequestParam("page") int page,
                                          @RequestParam("size") int size,
                                          @RequestParam("search") String licensePlate) {
        List<TicketDTO> ticketDTOList = ticketService.getAllTicket();
        Page<TicketDTO> ticketDTOPage;
        if (ticketDTOList.isEmpty()) {
            return new ResponseEntity<Page<TicketDTO>>(HttpStatus.NO_CONTENT);
        } else {
            if (licensePlate.equals("")) {
                ticketDTOPage = ticketService.pageFindAll(PageRequest.of(page, size));
            } else {
                ticketDTOPage = ticketService.findAllByVehicleLicensePlateContaining(PageRequest.of(page, size), licensePlate);
            }
        }
        return new ResponseEntity<>(ticketDTOPage, HttpStatus.OK);
    }

    @PostMapping("/ticket")
    public ResponseEntity<?> createTicket(@Valid @RequestBody TicketDTO ticketDTO) {
        if (ticketService.createTicket(ticketDTO)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("ticket/{idTicket}")
    public ResponseEntity<?> getTicketById(@PathVariable Long idTicket){
        TicketDTO ticketDTO = ticketService.findTicketById(idTicket);
        if (ticketDTO!= null){
            return new ResponseEntity<>(ticketDTO,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{idTicket}")
    public ResponseEntity<?> editTicket(@Valid @RequestBody TicketDTO ticketDTO, @PathVariable("idTicket") Long id) {
        if (ticketService.editTicket(id, ticketDTO)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{idTicket}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long idTicket) {
        if (ticketService.deleteTicket(idTicket)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}