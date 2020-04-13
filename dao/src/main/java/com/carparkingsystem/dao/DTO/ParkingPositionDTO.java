package com.carparkingsystem.dao.DTO;

public class ParkingPositionDTO {

    private Long idParkingPosition;

    private String nameOfPosition;

    private String positionStatus;

    private int idParkingFloor;

    public ParkingPositionDTO(Long idParkingPosition, String nameOfPosition, String positionStatus, int idParkingFloor) {
        this.idParkingPosition = idParkingPosition;
        this.nameOfPosition = nameOfPosition;
        this.positionStatus = positionStatus;
        this.idParkingFloor = idParkingFloor;
    }

    public Long getIdParkingPosition() {
        return idParkingPosition;
    }

    public void setIdParkingPosition(Long idParkingPosition) {
        this.idParkingPosition = idParkingPosition;
    }

    public String getNameOfPosition() {
        return nameOfPosition;
    }

    public void setNameOfPosition(String nameOfPosition) {
        this.nameOfPosition = nameOfPosition;
    }

    public String getPositionStatus() {
        return positionStatus;
    }

    public void setPositionStatus(String positionStatus) {
        this.positionStatus = positionStatus;
    }

    public int getIdParkingFloor() {
        return idParkingFloor;
    }

    public void setIdParkingFloor(int idParkingFloor) {
        this.idParkingFloor = idParkingFloor;
    }
}
