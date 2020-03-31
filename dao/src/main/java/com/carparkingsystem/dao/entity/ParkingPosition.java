package com.carparkingsystem.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "parkedposition")
public class ParkingPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idparkedposition")
    private Long idParkingPosition;

    @Column(name = "nameofposition")
    private String nameOfPosition;

    @Column(name = "statusofposition")
    private boolean positionStatus;

    @ManyToOne
    @JoinColumn(name="idparkingfloor", nullable=false)
    private ParkingFloor parkingFloor;

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

    public boolean isPositionStatus() {
        return positionStatus;
    }

    public void setPositionStatus(boolean positionStatus) {
        this.positionStatus = positionStatus;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }
}
