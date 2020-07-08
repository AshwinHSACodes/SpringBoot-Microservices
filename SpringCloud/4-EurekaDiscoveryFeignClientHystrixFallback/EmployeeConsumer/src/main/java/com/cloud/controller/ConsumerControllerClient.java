package com.cloud.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.cloud.domain.Employee;
import com.cloud.service.FeignClientServiceEmployeeProducer;

//@Controller
public class ConsumerControllerClient {

	@Autowired
	private FeignClientServiceEmployeeProducer feignClient;

	public void getEmployee() throws RestClientException, IOException {


		try {
			Employee emp = feignClient.getData();
			System.out.println(emp.toString());
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}