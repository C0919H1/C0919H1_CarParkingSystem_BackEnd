package com.carparkingsystem.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "tickettype")
public class TicketType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtickettype")
    private Long idTicketType;

    @Column(name = "nameoftickettype")
    private String nameTicketType;

    @Column(name = "cost")
    private int cost;

    public Long getIdTicketType() {
        return idTicketType;
    }

    public void setIdTicketType(Long idTicketType) {
        this.idTicketType = idTicketType;
    }

    public String getNameTicketType() {
        return nameTicketType;
    }

    public void setNameTicketType(String nameTicketType) {
        this.nameTicketType = nameTicketType;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
