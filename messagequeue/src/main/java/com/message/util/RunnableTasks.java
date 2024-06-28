package com.message.util;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class RunnableTasks {

	Runnable runnable;

	String name;

	public RunnableTasks(String name) {
		this.name = name;
	}

	public static Runnable getRunnableTask(String taskName) {
		Runnable runnableTask = () -> {
			Random random = new Random();
			String output;
			Thread.currentThread().setName(taskName);
			Path filePath = Paths.get("A:\\myjobsash\\messagequeue\\src\\main\\resources\\"+taskName+".txt");

			while (true) {
				int temp = random.nextInt(10);
				output = "\n" + Thread.currentThread().getName() + ":" + temp;
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Util.logOutPut(output, filePath);
			}
		};
		return runnableTask;
	}

}
