package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.cloud.filters.ErrorFilter;
import com.cloud.filters.PostFilter;
import com.cloud.filters.PreFilter;
import com.cloud.filters.RouteFilter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class EmployeeZuulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeZuulServiceApplication.class, args);
	}

	@Bean
	public PreFilter preFilter(){
		return new PreFilter();
	}
	
	@Bean
	public PostFilter postFilter(){
		return new PostFilter();
	}
	
	@Bean
	public ErrorFilter errorFilter(){
		return new ErrorFilter();
	}
	
	@Bean
	public RouteFilter routeFilter(){
		return new RouteFilter();
	}
}


