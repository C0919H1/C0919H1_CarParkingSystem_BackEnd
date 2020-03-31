package com.carparkingsystem.dao.repository;

import com.carparkingsystem.dao.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findAllByDeletedIsFalse();
    Customer findByIdCustomerAndDeletedIsFalse(Long id);
    Page<Customer> findAllByDeletedIsFalse(Pageable pageable);
    Page<Customer> findAllByDeletedIsFalseAndFullNameContaining(Pageable pageable,String fullName);
}
