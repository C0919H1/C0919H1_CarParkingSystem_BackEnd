package com.carparkingsystem.service.impl;

import com.carparkingsystem.dao.DTO.EmployeeDTO;
import com.carparkingsystem.dao.entity.Employee;
import com.carparkingsystem.dao.repository.EmployeeRepository;
import com.carparkingsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    String gender = "";

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> employeeList =  employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.isGender()) {
                gender = "Nam";
            } else gender = "Nữ";
            EmployeeDTO courseDTO = new EmployeeDTO(employee.getIdEmployee(), employee.getFullName(), employee.getDateOfBirth(), gender,employee.getPosition() ,employee.getPhoneNumber(), employee.getEmail(), employee.getAddress());
            employeeDTOS.add(courseDTO);
        }
        return employeeDTOS;
    }

    @Override
    public Page<EmployeeDTO> pageFindAll(Pageable pageable) {
        Page<Employee> employees = employeeRepository.findAllByDeletedIsFalse(pageable);
        Page<EmployeeDTO> employeeDTOPage = employees.map(course -> {
            if(course.isGender())
            {
                gender = "Nam";
            }else gender = "Nữ";
            EmployeeDTO employeeDTO = new EmployeeDTO(course.getIdEmployee(), course.getFullName(), course.getDateOfBirth(), gender, course.getPosition(), course.getPhoneNumber(), course.getEmail(), course.getAddress());
            return employeeDTO;
        });
        return employeeDTOPage;
    }

    @Override
    public EmployeeDTO getEmployeeDTO(Long idEmployee) {
        Employee employee = employeeRepository.findById(idEmployee).orElse(null);
        if (employee != null) {
            if(employee.isGender())
            {
                gender = "Nam";
            }else gender = "Nữ";
            return new EmployeeDTO(employee.getIdEmployee(), employee.getFullName(), employee.getDateOfBirth(), gender,employee.getPosition() ,employee.getPhoneNumber(), employee.getEmail(), employee.getAddress());
        }
        return null;
    }

    @Override
    public Employee getEmployee(Long idEmployee) {
        return employeeRepository.findById(idEmployee).orElse(null);
    }

    @Override
    public Page<EmployeeDTO> findAllByFullNameContaining(Pageable pageable, String fullName) {
        Page<Employee> employees = employeeRepository.findAllByDeletedIsFalseAndFullNameContaining(pageable, fullName);
        Page<EmployeeDTO> employeeDTOS;
        employeeDTOS = employees.map(employee -> {
            if(employee.isGender())
            {
                gender = "Nam";
            }else gender = "Nữ";
            EmployeeDTO employeeDTO = new EmployeeDTO(employee.getIdEmployee(), employee.getFullName(), employee.getDateOfBirth(), gender,employee.getPosition() ,employee.getPhoneNumber(), employee.getEmail(), employee.getAddress());
            return employeeDTO;
        });
        return employeeDTOS;
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
