package com.carparkingsystem.webservice.controller;

import com.carparkingsystem.dao.DTO.JwtResponse;
import com.carparkingsystem.dao.DTO.UserDTO;
import com.carparkingsystem.service.impl.UserServiceImpl;
import com.carparkingsystem.webservice.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Authorization")
@RequestMapping("")
public class UserController {
    @Autowired(required = false)
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired(required = false)
    UserServiceImpl userServiceImpl;

    private UserDTO userDTO;

    @GetMapping("/admin")
    public ResponseEntity<?> helloAdmin(){
        userDTO = new UserDTO("user","Hello");
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping("/employee")
    public ResponseEntity<?> helloEmployee(){
        userDTO = new UserDTO("employee","Hello");
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO user){
        System.out.println(user.getPassword());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword())
        );
        UserDetails userDetails = userServiceImpl
                .loadUserByUsername(authentication.getName());
        String jwtToken=jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok( new JwtResponse(jwtToken,userDetails.getUsername()));
    }
}
