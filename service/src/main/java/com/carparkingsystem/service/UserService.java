package com.carparkingsystem.service;

import com.carparkingsystem.dao.DTO.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();

    String findByNameEmployee(String username);

    String findByEmailEmployee(String username);
}
