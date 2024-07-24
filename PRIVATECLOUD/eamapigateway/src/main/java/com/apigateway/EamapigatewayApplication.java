package com.apigateway;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableDiscoveryClient
@CrossOrigin(origins = "http://localhost:4200")
public class EamapigatewayApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EamapigatewayApplication.class, args);
		System.setProperty("spring.config.name", "application");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("EamapigatewayApplication has been called......");
		
	}

}
