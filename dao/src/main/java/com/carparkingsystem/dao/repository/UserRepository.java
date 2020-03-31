package com.carparkingsystem.dao.repository;

import com.carparkingsystem.dao.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    User findByUserName(String userName);
}
