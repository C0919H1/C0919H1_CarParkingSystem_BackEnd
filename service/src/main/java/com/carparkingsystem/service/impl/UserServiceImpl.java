package com.carparkingsystem.service.impl;

import com.carparkingsystem.dao.DTO.UserDTO;
import com.carparkingsystem.dao.entity.Role;
import com.carparkingsystem.dao.entity.User;
import com.carparkingsystem.dao.repository.UserRepository;
import com.carparkingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDTO> findAll() {
        return null;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user == null){
            throw new UsernameNotFoundException("Người dùng không tồn tại trong hệ thống : "+ username);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<Role> roles = user.getRoles();
        for (Role role : roles){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getNameRole()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),
                grantedAuthorities);
    }

    @Override
    //Hàm dùng để lấy nameEmployee ở bảng User bằng cách tìm bằng username đã đăng nhập vào
    public String findByNameEmployee(String username) {
        //Kiểm tra trên db username có tồn tại trong hệ thống ko ?
        User user = userRepository.findByUserName(username);
        if(user==null) {
            return null;
        }
        return user.getEmployee().getFullName();
    }

    @Override
    public String findByEmailEmployee(String username) {
        User user = userRepository.findByUserName(username);
        if(user == null){
            return null;
        }
        return user.getEmployee().getEmail();
    }
}