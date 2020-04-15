package com.carparkingsystem.dao.DTO;

import java.util.Date;

public class VehicleTrackingTimeDTO {

    private Date timeIn;
    private Date timeOut;

    public VehicleTrackingTimeDTO() {
    }

    public VehicleTrackingTimeDTO(Date timeIn, Date timeOut) {
        this.timeIn = timeIn;
        this.timeOut = timeOut;
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
}
