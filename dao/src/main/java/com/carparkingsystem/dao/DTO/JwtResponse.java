package com.carparkingsystem.dao.DTO;

import java.io.Serializable;

public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    //Dùng để đẩy dữ liệu backend lên frontend; Kèm theo jwttoken
    private final String jwttoken;
    private String username;
    private String nameEmployee;

    public JwtResponse(String jwttoken, String username, String nameEmployee) {
        this.jwttoken = jwttoken;
        this.username = username;
        this.nameEmployee = nameEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken(){ return this.jwttoken;}
}
