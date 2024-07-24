package com.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.dto.Message;
import com.login.entity.UserInfo;
import com.login.service.JWTService;
import com.login.service.LoginService;

@CrossOrigin("*") 
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	JWTService jwtService;
	
    @GetMapping("/hello")
    public UserInfo sayHelloMethod(){
    	System.out.println("sayHelloMethod is called ..............");
        return new UserInfo();
    }
	
    @PostMapping("/register")
    public Message addNewUser(@RequestBody UserInfo userInfo){
        return loginService.addUser(userInfo);
    }
    
    @GetMapping("/all")
    public List<UserInfo> listAllUsers(){
    	List<UserInfo> list = loginService.listAllUsers();
        return list;
    }
    
    @PostMapping("/authenticate")
    public Message authenticateAndGetToken(@RequestBody UserInfo userInfo) {
    	return new Message(jwtService.generateToken(userInfo.getName()).toString());
    	 
    }
}
