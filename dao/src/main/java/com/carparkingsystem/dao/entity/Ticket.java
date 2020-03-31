package com.carparkingsystem.dao.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idticket")
    private Long idTicket;

    @ManyToOne
    @JoinColumn(name = "idtickettype", nullable = false)
    private TicketType ticketType;

    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "enddate")
    private Date endDate;

    @Column(name = "ticketregistrationdate")
    private Date dayRegistration;

    @Column(name = "deleted")
    private boolean deleted;

    @ManyToOne
    @JoinColumn(name = "idemployeeregistration", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "idparkedposition", nullable = false)
    private ParkingPosition parkingPosition;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_vehicle", referencedColumnName = "idvehicle")
    private Vehicle vehicle;

    @ManyToMany(targetEntity = Employee.class)
    @JoinTable(
            name = "ticketmanagementdetail",
            joinColumns = @JoinColumn(name = "idticket"),
            inverseJoinColumns = @JoinColumn(name = "idemployee")
    )
    private Set<Employee> employeeTicket;

    public Ticket(TicketType ticketType, Date startDate, Date endDate, Date dayRegistration, boolean deleted, Employee employee, ParkingPosition parkingPosition, Vehicle vehicle) {
        this.ticketType = ticketType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dayRegistration = dayRegistration;
        this.deleted = deleted;
        this.employee = employee;
        this.parkingPosition = parkingPosition;
        this.vehicle = vehicle;
    }

    public Ticket() {
    }

    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
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

    public Date getDayRegistration() {
        return dayRegistration;
    }

    public void setDayRegistration(Date dayRegistration) {
        this.dayRegistration = dayRegistration;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public ParkingPosition getParkingPosition() {
        return parkingPosition;
    }

    public void setParkingPosition(ParkingPosition parkingPosition) {
        this.parkingPosition = parkingPosition;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}

