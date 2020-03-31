package com.carparkingsystem.dao.entity;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ticketmanagementdetail")
public class TicketManagementDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmanagement")
    int id;

    @ManyToOne
    @JoinColumn(name = "idticket")
    Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "idemployee")
    Employee employee;

    @JoinColumn(name = "dayregistered")
    LocalDateTime registeredAt;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }
}
