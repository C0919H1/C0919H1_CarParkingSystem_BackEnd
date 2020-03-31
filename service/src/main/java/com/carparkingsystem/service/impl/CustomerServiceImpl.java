package com.carparkingsystem.service.impl;

import com.carparkingsystem.dao.DTO.CustomerDTO;
import com.carparkingsystem.dao.entity.Customer;
import com.carparkingsystem.dao.repository.CustomerRepository;
import com.carparkingsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    String gender = "";
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer customer : customerList) {
            if(customer.isGender())
            {
                gender = "Nam";
            }else gender = "Nữ";
            CustomerDTO courseDTO = new CustomerDTO(customer.getIdCustomer(), customer.getFullName(), customer.getDateOfBirth(), customer.getAddress(), customer.getEmail(), gender, customer.getPhoneNumber(), customer.getIdentify());
            customerDTOS.add(courseDTO);
        }
        return customerDTOS;
    }

    @Override
    public Page<CustomerDTO> pageFindAll(Pageable pageable) {
        Page<Customer> customers = customerRepository.findAllByDeletedIsFalse(pageable);
        Page<CustomerDTO> customerDTOPage = customers.map(course -> {
            if(course.isGender())
            {
                gender = "Nam";
            }else gender = "Nữ";
            CustomerDTO customerDTO = new CustomerDTO(course.getIdCustomer(), course.getFullName(), course.getDateOfBirth(), course.getAddress(), course.getEmail(), gender, course.getPhoneNumber(), course.getIdentify());
            return customerDTO;
        });
        return customerDTOPage;
    }

    @Override
    public CustomerDTO getCustomerDTO(Long idCustomer) {
        Customer customer = customerRepository.findById(idCustomer).orElse(null);
        if (customer != null) {
            if(customer.isGender())
            {
                gender = "Nam";
            }else gender = "Nữ";
            return new CustomerDTO(customer.getIdCustomer(), customer.getFullName(), customer.getDateOfBirth(), customer.getAddress(), customer.getEmail(), gender, customer.getPhoneNumber(), customer.getIdentify());
        }
        return null;
    }

    @Override
    public Customer getCustomer(Long idCustomer) {
        Customer customer = customerRepository.findById(idCustomer).orElse(null);
        return customer;
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Page<CustomerDTO> findAllByFullNameContaining(Pageable pageable, String fullName) {
        Page<Customer> customers = customerRepository.findAllByDeletedIsFalseAndFullNameContaining(pageable, fullName);
        Page<CustomerDTO> customerDTOS;
        customerDTOS = customers.map(customer -> {
            if(customer.isGender())
            {
                gender = "Nam";
            }else gender = "Nữ";
            CustomerDTO customerDTO = new CustomerDTO(customer.getIdCustomer(), customer.getFullName(), customer.getDateOfBirth(), customer.getAddress(), customer.getEmail(), gender, customer.getPhoneNumber(), customer.getIdentify());
            return customerDTO;
        });
        return customerDTOS;
    }

    @Override
    public boolean findCustomerByIdAndDeletedIsFalse(Long id) {
        Customer customer = this.customerRepository.findByIdCustomerAndDeletedIsFalse(id);
        if (customer != null) {
            customer.setDeleted(true);
            this.customerRepository.save(customer);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean editCustomer(CustomerDTO customerDTO, Long id)  {
        Customer customer = this.customerRepository.findByIdCustomerAndDeletedIsFalse(id);
        System.out.println(customerDTO.getGender());
        if (customer == null) {
            return false;
        } else {
            customer.setFullName(customerDTO.getFullName());
            customer.setEmail(customerDTO.getEmail());
            customer.setAddress(customerDTO.getAddress());
            if (customerDTO.getGender().equals("Nam")) {
                customer.setGender(false);
            } else if(customerDTO.getGender().equals("Nữ")) {
                customer.setGender(true);
            }
            System.out.println(customer.isGender());
            customer.setDateOfBirth(customerDTO.getDateOfBirth());
            customer.setIdentify(customerDTO.getIdentify());
            customer.setPhoneNumber(customerDTO.getPhoneNumber());
            this.customerRepository.save(customer);
            System.out.println(customer.isGender());
            return true;
        }
    }


}
