package com.carparkingsystem.dao.DTO;

public class VehicleDTO {

    private Long idVehicle;
    private String typeOfVehicle;
    private String licensePlate;
    private String endDate;
    private String ticketType;

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    private Long idCustomer;

    public VehicleDTO(Long idVehicle, String typeOfVehicle, String licensePlate, String endDate, String ticketType) {
        this.idVehicle = idVehicle;
        this.typeOfVehicle = typeOfVehicle;
        this.licensePlate = licensePlate;
        this.endDate = endDate;
        this.ticketType = ticketType;
    }

    public Long getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(Long idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(String typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
}
