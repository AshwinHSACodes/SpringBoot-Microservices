package com.cloud.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClientException;

import com.cloud.domain.Employee;
import com.cloud.service.FeignClientServiceEmployeeProducer;

//@Controller
public class ConsumerControllerClient {

	@Autowired
	private FeignClientServiceEmployeeProducer feignClient;

	public void getEmployee() throws RestClientException, IOException {

		try {
			for (int i = 0; i <= 100; i++) {
				Employee emp = feignClient.getData();
				System.out.println(emp.toString());
			}
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