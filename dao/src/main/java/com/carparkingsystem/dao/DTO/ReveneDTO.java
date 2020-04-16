package com.carparkingsystem.dao.DTO;

public class ReveneDTO {
    private int year;
    private int revenue;

    public ReveneDTO(int year, int revenue) {
        this.year = year;
        this.revenue = revenue;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }
}
