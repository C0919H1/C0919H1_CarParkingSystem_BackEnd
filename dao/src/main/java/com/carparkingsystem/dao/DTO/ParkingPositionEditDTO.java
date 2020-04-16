package com.carparkingsystem.dao.DTO;

import com.carparkingsystem.dao.entity.ParkingPosition;

public class ParkingPositionEditDTO {
    private int floor;
    private ParkingPosition parkingPosition;

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public ParkingPosition getParkingPosition() {
        return parkingPosition;
    }

    public void setParkingPosition(ParkingPosition parkingPosition) {
        this.parkingPosition = parkingPosition;
    }
}
