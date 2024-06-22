package com.eam.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eam.entity.Attendance;
import com.eam.repository.AttendanceRepository;

@Service
public class AttendanceService {

	@Autowired
	AttendanceRepository attendanceRepository;
	
	public Attendance saveLoginTime(Long empid) {
		Attendance attendance = new Attendance();
		
		LocalDateTime dateTime = LocalDateTime.now();
		String date = dateTime.format(DateTimeFormatter.ofPattern("dd-mm-yyyy"));
		System.out.println(date);
		date = dateTime.getDayOfMonth() + "-" + dateTime.getMonth() + "-" + dateTime.getYear();
		
		attendance.setEmpid(empid);
		attendance.setDate(date);
		String time = dateTime.getHour() + ":" + dateTime.getMinute() + ":" + dateTime.getSecond();
		attendance.setLoginTime(time);
				
		return attendanceRepository.save(attendance);
	}
	
	public List<Attendance> getTodayAttendanceList(){
		LocalDateTime dateTime = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-mm-yyyy");
		
		String todayDate = dateTime.getDayOfMonth() + "-" + dateTime.getMonth() + "-" + dateTime.getYear();
		
		System.out.println(todayDate);
		return attendanceRepository.findByDate(todayDate);
	}
}
