package com.carparkingsystem.webservice.controller;

import com.carparkingsystem.dao.entity.TicketType;
import com.carparkingsystem.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TicketTypeController {
    @Autowired
    TicketTypeService ticketTypeService;

    @GetMapping("/tickettypes")
    public ResponseEntity<?> listAllTicketType(){
        List<TicketType> ticketTypes = ticketTypeService.getAllTicketType();
        if (ticketTypes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticketTypes, HttpStatus.OK);
    }

    @GetMapping("/tickettypes/{id}")
    public ResponseEntity<?> ticketType(@PathVariable Long id){
        TicketType ticketType = ticketTypeService.getTicketTypeById(id);
        if(ticketType == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticketType, HttpStatus.OK);
    }
}
