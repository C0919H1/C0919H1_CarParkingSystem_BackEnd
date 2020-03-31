package com.carparkingsystem.webservice.controller;

import com.carparkingsystem.dao.DTO.CustomerDTO;
import com.carparkingsystem.dao.entity.Customer;
import com.carparkingsystem.dao.entity.Employee;
import com.carparkingsystem.dao.entity.Vehicle;
import com.carparkingsystem.service.CustomerService;
import com.carparkingsystem.service.VehicleService;
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
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    VehicleService vehicleService;

    @GetMapping(value = "/customers", params = {"page", "size", "search"})
    public ResponseEntity<?> listAllCustomers(@RequestParam("page") int page,
                                              @RequestParam("size") int size,
                                              @RequestParam("search") String nameCustomer) {
        List<CustomerDTO> customerDTOS = customerService.getAllCustomer();
        Page<CustomerDTO> customerDTOPage;
        if (customerDTOS.isEmpty()) {
            return new ResponseEntity<Page<CustomerDTO>>(HttpStatus.NO_CONTENT);
        } else {
            if (nameCustomer.equals("")) {
                customerDTOPage = customerService.pageFindAll(PageRequest.of(page, size));
            } else {
                customerDTOPage = customerService.findAllByFullNameContaining(PageRequest.of(page, size), nameCustomer);
            }
        }
        return new ResponseEntity<>(customerDTOPage, HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<?> findCustomer(@PathVariable Long id) {
        CustomerDTO customerDTO = customerService.getCustomerDTO(id);
        if (customerDTO == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<?> createCustomer(@Valid @RequestBody CustomerDTO customer) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd");
        Employee employee = new Employee();
        employee.setIdEmployee((long)1);
        Customer customerTemp = new Customer();
        customerTemp.setFullName(customer.getFullName());
        customerTemp.setDateOfBirth(customer.getDateOfBirth());
        customerTemp.setAddress(customer.getAddress());
        customerTemp.setEmail(customer.getEmail());
        if (customer.getGender().toLowerCase() == "nam") {
            customerTemp.setGender(false);
        } else customerTemp.setGender(true);
        customerTemp.setPhoneNumber(customer.getPhoneNumber());
        customerTemp.setIdentify(customer.getIdentify());
        customerTemp.setEmployee(employee);
        customerTemp.setDeleted(false);
        customerService.saveCustomer(customerTemp);
        Vehicle vehicle = new Vehicle();
        vehicle.setLicensePlate(" ");
        vehicle.setTypeOfVehicle("");
        vehicle.setCustomer(customerService.getCustomer(customerTemp.getIdCustomer()));
        vehicle.setDeleted(false);
        vehicle.setDeleted(false);
        vehicleService.saveVehicle(vehicle);
        return new ResponseEntity<>(customerTemp, HttpStatus.CREATED);
    }

    @PatchMapping({"/customers/{id}"})
    public ResponseEntity<?> deletedCustomerById(@PathVariable(name = "id") Long id) {
        return this.customerService.findCustomerByIdAndDeletedIsFalse(id) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping({"customers/{id}"})
    public ResponseEntity<?> editCustomer(@Valid @RequestBody CustomerDTO customerDTO, @PathVariable Long id) {
        return this.customerService.editCustomer(customerDTO, id) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
