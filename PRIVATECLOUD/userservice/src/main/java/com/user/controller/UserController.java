package com.user.controller;

import java.util.List;

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

	@Autowired
	UserService userService;
	
	@GetMapping("/hello")
	public String sayHelloMethod() {
		return "Hello from user service";
	}
	
	@PostMapping("adduser")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@GetMapping(value = "/getUserById/{id}")
	public User getUserById(@PathVariable("id") Long id) {
		System.out.println(id);
		return userService.getUserById(id);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/getByEmail/{emailid}")
	public User getUserByEmail(@PathVariable(value = "emailid") String emailid) {
		return userService.getUserByEmail(emailid);
	}
}
