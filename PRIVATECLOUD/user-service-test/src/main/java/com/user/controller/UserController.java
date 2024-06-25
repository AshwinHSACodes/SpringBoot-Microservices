package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.user.feign.UserFeignClient;

@RestController
@RequestMapping("employee")
public class UserController {

	@Autowired
	EurekaClient eurekaClient;

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	UserFeignClient userFeignClient;

	@GetMapping("hello")
	public String getHelloMessage() {

		InstanceInfo server = eurekaClient.getApplication("EMPLOYEE-SERVICE").getInstances().get(0);

		String url = server.getHomePageUrl();

		System.out.println(url);

		ResponseEntity<String> response = restTemplate.getForEntity(url + "/employee/hello", String.class);

		return response.getBody();

	}
	
	@GetMapping("feignClientHello")
	public String getHelloMessageFeignClient() {
		return userFeignClient.getHelloMessage().getBody();
	}
	
	@GetMapping("actuator/health")
	public String getHealthStatus() {
		return userFeignClient.getHealthStatus();
	}
	
}
