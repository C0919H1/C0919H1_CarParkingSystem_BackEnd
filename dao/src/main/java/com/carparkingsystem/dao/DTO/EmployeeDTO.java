package com.carparkingsystem.dao.DTO;

import java.util.Date;

public class EmployeeDTO {
    private Long idEmployee;
    private String fullName;
    private Date dateOfBirth;
    private String gender;
    private String position;
    private String email;
    private String address;
    private String phoneNumber;

    public EmployeeDTO(Long idEmployee, String fullName, Date dateOfBirth, String gender, String position, String email, String address, String phoneNumber) {
        this.idEmployee = idEmployee;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.position = position;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
