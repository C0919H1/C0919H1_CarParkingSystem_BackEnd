package com.carparkingsystem.dao.DTO;

public class TicketDTO2 {
    private Long idTicket;
    private String startDate;
    private String endDate;
    private String dayRegistration;

    public TicketDTO2(Long idTicket, String startDate, String endDate, String dayRegistration) {
        this.idTicket = idTicket;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dayRegistration = dayRegistration;
    }

    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDayRegistration() {
        return dayRegistration;
    }

    public void setDayRegistration(String dayRegistration) {
        this.dayRegistration = dayRegistration;
    }
}
