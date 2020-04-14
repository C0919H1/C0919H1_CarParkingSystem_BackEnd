package com.carparkingsystem.webservice.controller;

import com.carparkingsystem.dao.DTO.JwtResponse;
import com.carparkingsystem.dao.DTO.UserDTO;
import com.carparkingsystem.service.UserService;
import com.carparkingsystem.service.impl.UserServiceImpl;
import com.carparkingsystem.webservice.security.JwtTokenUtil;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Authorization")
@RequestMapping("")
public class UserController {
    @Autowired(required = false)
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired(required = false)
    UserService userService;

    @Qualifier("UserServiceImpl")
    @Autowired(required = false)
    UserDetailsService userDetailsService;

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
        //Truyền dữ liệu lên frontend thông qua token
        UserDetails userDetails = userDetailsService
                .loadUserByUsername(authentication.getName());
        String jwtToken=jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok( new JwtResponse(jwtToken,userDetails.getUsername(), userService.findByNameEmployee(user.getUsername())));
    }

    @GetMapping("/forgot-password/{username}")
    //Gửi lên body web một string username
    public ResponseEntity<?> forgotPassword(@PathVariable String username) throws JSONException {
        String nameEmployee= userService.findByNameEmployee(username);
        //Kiểm tra nếu username có tồn tại trong hệ thống ko? Trả về 2 kết quả
        if(nameEmployee==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            Map<String,String> map=new HashMap<>();
            map.put("email",userService.findByEmailEmployee(username));
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
    }
}
