package com.carparkingsystem.service;

import com.carparkingsystem.dao.entity.TicketType;
import java.util.List;

public interface TicketTypeService {
    List<TicketType> getAllTicketType();
    TicketType getTicketTypeById(Long idTicketType);
    TicketType getAllTicketTypeById(Integer idTicketType);
    TicketType getAllTicketTypeByName(String nameTicketType);
}
