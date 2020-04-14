package com.carparkingsystem.dao.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vehicle_tracking_time")
public class VehicleTrackingTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvehicle_tracking_time")
    private Long idVehicleTrackingTime;

    @Column(name = "time_in")
    private Date timeIn;

    @Column(name = "time_out")
    private Date timeOut;

    @Column(name = "delete")
    private boolean deleted;

    @ManyToOne
    @JoinColumn(name="id_car", nullable=false)
    private Vehicle vehicle;

    public VehicleTrackingTime() {
    }

    public VehicleTrackingTime(Date timeIn, Date timeOut, boolean deleted, Vehicle vehicle) {
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.deleted = deleted;
        this.vehicle = vehicle;
    }

    public Long getIdVehicleTrackingTime() {
        return idVehicleTrackingTime;
    }

    public void setIdVehicleTrackingTime(Long idVehicleTrackingTime) {
        this.idVehicleTrackingTime = idVehicleTrackingTime;
    }

    public Date getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(Date timeIn) {
        this.timeIn = timeIn;
    }

    public Date getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Date timeOut) {
        this.timeOut = timeOut;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
