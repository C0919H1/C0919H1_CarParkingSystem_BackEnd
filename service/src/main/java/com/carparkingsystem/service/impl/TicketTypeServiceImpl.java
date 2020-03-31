package com.carparkingsystem.service.impl;

import com.carparkingsystem.dao.entity.TicketType;
import com.carparkingsystem.dao.repository.TicketTypeRepository;
import com.carparkingsystem.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TicketTypeServiceImpl implements TicketTypeService {
    @Autowired
    TicketTypeRepository ticketTypeRepository;

    @Override
    public List<TicketType> getAllTicketType() {
        return ticketTypeRepository.findAll();
    }

    @Override
    public TicketType getTicketTypeById(Long idTicketType) {
        return ticketTypeRepository.findAllByIdTicketType(idTicketType);
    }

    @Override
    public TicketType getAllTicketTypeById(Integer idTicketType) {
        return ticketTypeRepository.findAllByIdTicketType(idTicketType);
    }

    @Override
    public TicketType getAllTicketTypeByName(String nameTicketType) {
        return ticketTypeRepository.findAllByNameTicketType(nameTicketType);
    }
}