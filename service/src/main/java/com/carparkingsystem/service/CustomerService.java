package com.carparkingsystem.service;

import com.carparkingsystem.dao.DTO.CustomerDTO;
import com.carparkingsystem.dao.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomer();
    Page<CustomerDTO> pageFindAll(Pageable pageable);
    CustomerDTO getCustomerDTO(Long idCustomer);
    Customer getCustomer(Long idCustomer);
    void saveCustomer(Customer customer);
    Page<CustomerDTO> findAllByFullNameContaining(Pageable pageable, String fullName);
    boolean findCustomerByIdAndDeletedIsFalse(Long id);
    boolean editCustomer(CustomerDTO customerDTO, Long id);

    static int thanh() {
        return 0;
    }


}
