package com.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.domain.Employee;

@FeignClient(name="employee-producer")
public interface FeignClientServiceEmployeeProducer {

	@RequestMapping(method=RequestMethod.GET, value="/employee")
	public Employee getData();
}
