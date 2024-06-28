package com.message;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;
import java.util.stream.Stream;

public class IOT_AC_DATA_CONSUMER {
	public static void main(String[] args) throws Exception {
		generateInput();
	}

	private static void generateInput() throws InterruptedException, IOException {
		Random random = new Random();
		String output;
		Thread.currentThread().setName("AC1");

		String pathAlert = "A:\\myjobsash\\JAVA\\javacodes\\IOT_DATA_IN\\General\\Alert.txt";
		
		while (true) {
			Thread.sleep(1000);
			Stream<String> lines = Files.lines(Paths.get(pathAlert));
			lines.forEach(System.out::println);
			BufferedWriter writer = Files.newBufferedWriter(Paths.get(pathAlert));
			writer.write("");
			writer.flush();
		}
	}

	private static void logOutPut(String output, Path path) throws IOException {
		Files.write(path, output.getBytes(), StandardOpenOption.APPEND);
	}

}
