package com.carparkingsystem.dao.repository;

import com.carparkingsystem.dao.entity.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketTypeRepository extends JpaRepository<TicketType,Integer> {
    TicketType findAllByNameTicketType(String nameTicketType);
    TicketType findAllByIdTicketType(Integer idTicketType);
    TicketType findAllByIdTicketType(Long idTicketType);
}