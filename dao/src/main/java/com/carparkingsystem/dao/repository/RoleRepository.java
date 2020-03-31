package com.carparkingsystem.dao.repository;

import com.carparkingsystem.dao.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findByNameRole(String nameRole);
}
