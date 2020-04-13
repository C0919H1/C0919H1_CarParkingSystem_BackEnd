package com.carparkingsystem.dao.DTO;

import java.util.Date;

public class TicketDTO3 {

    private Long idTicket;
    private String idVehicle;
    private String typeVehicle;
    private String fullName;
    private String phoneNumber;
    private String email;
    private Date dateOfBirth;
    private Date startDate;
    private Date endDate;
    private String nameFloor;
    private String nameOfPosition;
    private String ticketType;
    private int cost;

    public TicketDTO3() {
    }

    public TicketDTO3(Long idTicket, String idVehicle, String typeVehicle, String fullName, String phoneNumber, String email, Date dateOfBirth, Date startDate, Date endDate, String nameFloor, String nameOfPosition, String ticketType, int cost) {
        this.idTicket = idTicket;
        this.idVehicle = idVehicle;
        this.typeVehicle = typeVehicle;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
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

    public String getTypeVehicle() {
        return typeVehicle;
    }

    public void setTypeVehicle(String typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

