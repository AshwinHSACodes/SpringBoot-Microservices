package com.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@GetMapping("/hello")
	public String sayHelloMethod() {

        // Logging various log level messages 
        logger.trace("Log level: TRACE"); 
        logger.info("Log level: INFO"); 
        logger.debug("Log level: DEBUG"); 
        logger.error("Log level: ERROR"); 
        logger.warn("Log level: WARN"); 
		
		return "Hello from user service";
	}
	
	@PostMapping("adduser")
	public User addUser(@RequestBody User user) {
		logger.info("user : " + user);
		return userService.addUser(user);
	}
	
	@GetMapping(value = "/getUserById/{id}")
	public User getUserById(@PathVariable("id") Long id) {
		logger.info("id : " +id);
		return userService.getUserById(id);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers(){
		logger.info(" getAllUsers called");
		return userService.getAllUsers();
	}
	
	@GetMapping("/getByEmail/{emailid}")
	public User getUserByEmail(@PathVariable(value = "emailid") String emailid) {
		logger.info("emailid : " + emailid);
		return userService.getUserByEmail(emailid);
	}
}
