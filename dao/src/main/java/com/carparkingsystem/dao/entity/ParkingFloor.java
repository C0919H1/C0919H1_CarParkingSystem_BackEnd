package com.carparkingsystem.dao.entity;


import javax.persistence.*;

@Entity
@Table(name = "parkingfloor")
public class ParkingFloor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idparkingfloor")
    private int idParkingFloor;

    @Column(name = "namefloor")
    private String nameFloor;

    @Column(name = "amount")
    private int amount;

    public int getIdParkingFloor() {
        return idParkingFloor;
    }

    public void setIdParkingFloor(int idParkingFloor) {
        this.idParkingFloor = idParkingFloor;
    }

    public String getNameFloor() {
        return nameFloor;
    }

    public void setNameFloor(String nameFloor) {
        this.nameFloor = nameFloor;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

