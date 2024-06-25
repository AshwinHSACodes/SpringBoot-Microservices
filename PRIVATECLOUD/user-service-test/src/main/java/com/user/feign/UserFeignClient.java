package com.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "EMPLOYEE-SERVICE")
public interface UserFeignClient {

	@GetMapping("/employee/hello")
	public ResponseEntity<String> getHelloMessage();

	@GetMapping("actuator/health")
	public String getHealthStatus();
}
