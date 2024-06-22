package com.eam;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class WorkBook {

	public static void main(String[] args) {

		ZoneId zoneId = ZoneId.of("Asia/Kolkata");
		
		LocalDateTime date = LocalDateTime.now();
		System.out.println(date);
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-mm-yyyy");
		System.out.println(date.format(format));
		System.out.println(date.getHour() + " : " + date.getMinute() + " : " + date.getSecond());
	}

}
