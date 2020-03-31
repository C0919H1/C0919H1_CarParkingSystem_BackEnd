package com.carparkingsystem.dao.entity;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcustomer")
    private Long idCustomer;

    @Column(name = "fullname")
    @NotBlank(message = "Họ Tên Không Được Để Trống")
    private String fullName;

    @Column(name = "dateofbirth")
    private Date dateOfBirth;

    @Column(name = "address")
    @NotBlank(message = "Địa Chỉ Không Được Để Trống")
    private String address;

    @Column(name = "email")
    @NotBlank(message = "Email Không Được Để Trống")
    private String email;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "numberphone")
    @NotBlank(message = "Số Điện Thoại Không Được Để Trống")
    private String phoneNumber;

    @Column(name = "identify")
    @NotBlank(message = "Số CMND Không Được Để Trống")
    private String identify;

    @Column(name = "deleted")
    private boolean deleted;

    @ManyToOne
    @JoinColumn(name="idemployeeregistration", nullable=false)
    private Employee employee;

    @ManyToMany(targetEntity=Employee.class)
    @JoinTable(
            name = "customerinfomationmanagementdetail",
            joinColumns = @JoinColumn(name = "idcustomer"),
            inverseJoinColumns = @JoinColumn(name = "idemployee")
    )
    private Set<Employee> employees;

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
