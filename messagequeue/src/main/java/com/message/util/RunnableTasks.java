package com.message.util;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

import org.springframework.cglib.core.Local;

public class RunnableTasks {

	Runnable runnable;

	String name;

	public RunnableTasks(String name) {
		this.name = name;
	}

	public static Runnable getRunnableTaskWrite(String taskName) {
		Runnable runnableTask = () -> {
			Random random = new Random();
			String output;
			Thread.currentThread().setName(taskName);
			Path filePath = Paths.get("A:\\AshwinHSACodes\\SpringBoot-Microservices\\messagequeue\\src\\main\\resources\\" + taskName + ".txt");

			while (true) {
				int temp = random.nextInt(10);
				output = "\n" + Thread.currentThread().getName() + ":" + temp;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Util.writeToFile(output, filePath);
			}
		};
		return runnableTask;
	}

	public static Runnable getRunnableTaskRead(String[] taskNames) {
		Runnable runnableTask = () -> {
			String output;
			String fileWritePath = "A:\\AshwinHSACodes\\SpringBoot-Microservices\\messagequeue\\src\\main\\resources\\ConsolidatedData.txt";
			Thread.currentThread().setName("ReadTask");
			try {
				while (true) {
					Thread.sleep(5000);
					for (int i = 0; i < taskNames.length; i++) {
						String fileName = taskNames[i];
						Path fileReadPath = Paths
								.get("A:\\AshwinHSACodes\\SpringBoot-Microservices\\messagequeue\\src\\main\\resources\\" + fileName + ".txt");
						Util.readOutPutAndDeleteContents(fileReadPath, Paths.get(fileWritePath) );
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
		return runnableTask;
	}
	
	public static Runnable getAlertTask() {
		
		Path fileReadPath = Paths.get("A:\\AshwinHSACodes\\SpringBoot-Microservices\\messagequeue\\src\\main\\resources\\ConsolidatedData.txt");
		Path alertFilePath = Paths.get("A:\\AshwinHSACodes\\SpringBoot-Microservices\\messagequeue\\src\\main\\resources\\Alert.txt");
		LocalDateTime localDateTime = LocalDateTime.now();
		Runnable alertTask = ()->{
		
			while(true) {
				try {
					Thread.sleep(10000);
					Stream<String> lines = Files.lines(fileReadPath);
					lines.forEach(s->{
						if( !s.equals("") && Integer.valueOf(String.valueOf(s.charAt(4)))>=8) {
							s = localDateTime.toString()+ s +"\n";
							Util.writeToFile(s, alertFilePath);
						}
					});
					BufferedWriter deleteWriter = Files.newBufferedWriter(fileReadPath);
					deleteWriter.write("");
					deleteWriter.flush();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		return alertTask;
	}
	
	public static Runnable getAnalyzeTask() throws Exception{
		
		Path fileReadPath = Paths.get("A:\\AshwinHSACodes\\SpringBoot-Microservices\\messagequeue\\src\\main\\resources\\Alert.txt");
		Path analysisWritePath = Paths.get("A:\\AshwinHSACodes\\SpringBoot-Microservices\\messagequeue\\src\\main\\resources\\Analysis.txt");
		BufferedWriter analysisWriter = Files.newBufferedWriter(analysisWritePath);
		LocalDateTime localDateTime = LocalDateTime.now();
		
		Map<String, Integer> temperatreMap = new HashMap<>();
		Map<String, Integer> countMap = new HashMap<>();
		
		Runnable analysisTask = ()->{
			while(true) {
				try {
					Thread.sleep(30000);
					Stream<String> lines = Files.lines(fileReadPath);
					Map<String, Map<String,Integer>> consolidatedMap = Util.getTemperatureNamesMappedValues(lines);

					String outputString = LocalDateTime.now().toString() + "\n";
					Util.writeToFile(outputString, analysisWritePath);
					Util.writeToFile(consolidatedMap.get("machines").toString()+"\n", analysisWritePath);
					Util.writeToFile(consolidatedMap.get("count").toString()+"\n", analysisWritePath);
					analysisWriter.flush();
					consolidatedMap.clear();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		return analysisTask;
	}
}
