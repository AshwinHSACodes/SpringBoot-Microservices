package com.message.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Util {

	public static void writeToFile(String output, Path path) {
		try {
			Files.write(path, output.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readOutPutAndDeleteContents(Path filePathRead, Path filePathWrite) throws InterruptedException{
		try {
			
				Thread.sleep(1000);
				Stream<String> lines = Files.lines(filePathRead);
				lines.forEach(s->{try {
					Files.write(filePathWrite, (s+"\n").getBytes(), StandardOpenOption.APPEND);
				} catch (IOException e) {
					e.printStackTrace();
				}});
				BufferedWriter deleteWriter = Files.newBufferedWriter(filePathRead);
				deleteWriter.write("");
				deleteWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Map<String, Map<String,Integer>> getTemperatureNamesMappedValues(Stream<String> lines){
		
		Map<String, Map<String,Integer>> consolidatedMap = new HashMap<>();
		Map<String, Integer> temperatreMap = new HashMap<>();
		Map<String, Integer> countMap = new HashMap<>();
		
		lines.forEach(s->{
				String AC = "AC" + String.valueOf(s.charAt(s.length()-3));
				if(temperatreMap.get(AC)==null) {
					temperatreMap.put(AC,Integer.valueOf(String.valueOf(s.charAt(s.length()-1))));
					countMap.put(AC, 1);
				}else {
					int currentTemp = temperatreMap.get(AC) + Integer.valueOf(String.valueOf(s.charAt(s.length()-1)));
					temperatreMap.put(AC, currentTemp);
					int index = countMap.get(AC) + 1;
					countMap.put(AC, index);
				}
		});
		consolidatedMap.put("machines", temperatreMap);
		consolidatedMap.put("count", countMap);
		
		return consolidatedMap;
	}
}
