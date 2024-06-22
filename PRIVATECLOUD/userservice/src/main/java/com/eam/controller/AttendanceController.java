package com.eam.controller;

import java.util.List;

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
	
	@PostMapping("saveLoginTime")
	public Attendance saveAttendance(@RequestBody Attendance attendance) {
		return attendanceService.saveLoginTime(attendance.getEmpid());
	}
	
	@GetMapping("getTodayAttendanceList")
	public List<Attendance> getTodayAttendanceList() {
		return attendanceService.getTodayAttendanceList();
	}
}
