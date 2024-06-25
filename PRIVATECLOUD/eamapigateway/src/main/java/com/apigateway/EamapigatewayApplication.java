package com.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EamapigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EamapigatewayApplication.class, args);
		System.setProperty("spring.config.name", "application");
	}

}
