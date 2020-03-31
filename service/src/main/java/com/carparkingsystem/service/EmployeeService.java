package com.carparkingsystem.service;


import com.carparkingsystem.dao.DTO.EmployeeDTO;
import com.carparkingsystem.dao.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployee();

    Page<EmployeeDTO> pageFindAll(Pageable pageable);

    EmployeeDTO getEmployeeDTO(Long idEmployee);

    Employee getEmployee(Long idEmployee);

    Page<EmployeeDTO> findAllByFullNameContaining(Pageable pageable, String fullName);

    void saveEmployee(Employee employee);
}
