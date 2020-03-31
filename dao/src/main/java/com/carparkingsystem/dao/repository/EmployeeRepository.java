package com.carparkingsystem.dao.repository;

import com.carparkingsystem.dao.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByDeletedIsFalse();
    Employee findByIdEmployeeAndDeletedIsFalse(Long id);
    Page<Employee> findAllByDeletedIsFalse(Pageable pageable);
    Page<Employee> findAllByDeletedIsFalseAndFullNameContaining(Pageable pageable,String fullName);
}
