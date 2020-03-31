package com.carparkingsystem.webservice.controller;

import com.carparkingsystem.dao.DTO.EmployeeDTO;
import com.carparkingsystem.dao.entity.Employee;
import com.carparkingsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping(value ="/employees",params = {"page","size","search"})
    public ResponseEntity<?> getAllEmployees(@RequestParam("page") int page,
                                            @RequestParam("size") int size,
                                            @RequestParam("search") String nameEmployee) {

        List<EmployeeDTO> employeeDTOS =  employeeService.getAllEmployee();
        Page<EmployeeDTO> employeeDTOPage;
        if (employeeDTOS.isEmpty()) {
            return new ResponseEntity<Page<EmployeeDTO>>(HttpStatus.NO_CONTENT);
        }else {
            if (nameEmployee.equals("")) {
                employeeDTOPage = employeeService.pageFindAll(PageRequest.of(page, size));
            } else {
                employeeDTOPage = employeeService.findAllByFullNameContaining(PageRequest.of(page, size), nameEmployee);
            }
        }
        return new ResponseEntity<>(employeeDTOPage, HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<?> findCustomer(@PathVariable Long id) {
        EmployeeDTO employeeDTO = employeeService.getEmployeeDTO(id);
        if (employeeDTO == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }
    @PostMapping("/employees")
    public ResponseEntity<?> createCustomer(@Valid @RequestBody EmployeeDTO employee) {
        Employee employeeTemp = new Employee();
        employeeTemp.setFullName(employee.getFullName());
        employeeTemp.setDateOfBirth(employee.getDateOfBirth());
        employeeTemp.setAddress(employee.getAddress());
        employeeTemp.setEmail(employee.getEmail());
        if (employee.getGender().toLowerCase() == "Nam") {
            employeeTemp.setGender(false);
        } else employeeTemp.setGender(true);
        employeeTemp.setPhoneNumber(employee.getPhoneNumber());
        employeeTemp.setPosition(employee.getPosition());
        employeeTemp.setDeleted(true);
        employeeService.saveEmployee(employeeTemp);
        return new ResponseEntity<>(employeeTemp, HttpStatus.CREATED);
    }

}
