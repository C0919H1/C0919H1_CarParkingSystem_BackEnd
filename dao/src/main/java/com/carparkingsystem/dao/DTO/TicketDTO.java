package com.carparkingsystem.dao.DTO;

import java.util.Date;

public class TicketDTO {

    private Long idTicket;

    private String idVehicle;
    private String fullName;
    private Date startDate;
    private Date endDate;
    private String nameFloor;
    private String nameOfPosition;
    private String ticketType;
    private int cost;

    public TicketDTO() {
    }

    public TicketDTO(Long idTicket, String idVehicle, String fullName, Date startDate, Date endDate, String nameFloor, String nameOfPosition, String ticketType, int cost) {
        this.idTicket = idTicket;
        this.idVehicle = idVehicle;
        this.fullName = fullName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.nameFloor = nameFloor;
        this.nameOfPosition = nameOfPosition;
        this.ticketType = ticketType;
        this.cost = cost;
    }

    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public String getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(String idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getNameFloor() {
        return nameFloor;
    }

    public void setNameFloor(String nameFloor) {
        this.nameFloor = nameFloor;
    }

    public String getNameOfPosition() {
        return nameOfPosition;
    }

    public void setNameOfPosition(String nameOfPosition) {
        this.nameOfPosition = nameOfPosition;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
