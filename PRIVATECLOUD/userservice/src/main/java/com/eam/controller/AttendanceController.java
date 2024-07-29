package com.eam.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eam.entity.Attendance;
import com.eam.service.AttendanceService;

@RestController
@RequestMapping("attendance")
public class AttendanceController {

	@Autowired
	AttendanceService attendanceService;
	
	Logger logger = LoggerFactory.getLogger(AttendanceController.class);
	
	@GetMapping("/hello")
	public String sayHelloMethod() {

        // Logging various log level messages 
        logger.trace("Log level: TRACE"); 
        logger.info("Log level: INFO"); 
        logger.debug("Log level: DEBUG"); 
        logger.error("Log level: ERROR"); 
        logger.warn("Log level: WARN"); 
		
		return "Hello from attendance controller service";
	}
	
	@PostMapping("saveLoginTime")
	public Attendance saveAttendance(@RequestBody Attendance attendance) {
		return attendanceService.saveLoginTime(attendance.getEmpid());
	}
	
	@GetMapping("getTodayAttendanceList")
	public List<Attendance> getTodayAttendanceList() {
		return attendanceService.getTodayAttendanceList();
	}
}
