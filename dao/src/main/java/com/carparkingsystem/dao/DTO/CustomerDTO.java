package com.carparkingsystem.dao.DTO;

import java.util.Date;

public class CustomerDTO {
    private Long idCustomer;
    private String fullName;
    private Date dateOfBirth;
    private String address;
    private String email;
    private String gender;
    private String phoneNumber;
    private String identify;

    public CustomerDTO(Long idCustomer, String fullName, Date dateOfBirth, String address, String email, String gender, String phoneNumber, String identify) {
        this.idCustomer = idCustomer;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.identify = identify;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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
}
