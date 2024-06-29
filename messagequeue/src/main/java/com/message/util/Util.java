package com.message.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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
	
	
}
