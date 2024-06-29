package com.message.util;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.concurrent.Callable;

public class CallableTask {

	Callable<Integer> runnable;

	String taskName;

	public CallableTask(String taskName) {
		this.taskName = taskName;
	}

	public static Callable<Integer> getCallableTask(String taskName) {
		Callable callableTask = () -> {
			Random random = new Random();
			String output;
			Thread.currentThread().setName(taskName);
			Path filePath = Paths.get("A:\\myjobsash\\messagequeue\\src\\main\\resources\\"+taskName+".txt");
			
			while (true) {
				int randomNumber = random.nextInt(10);
				output = "\n" + Thread.currentThread().getName() + ":" + randomNumber;
				try {
					Thread.sleep(5000);
					//Util.logOutPut(output, filePath);
					return randomNumber;
				} catch (InterruptedException e) {
					e.printStackTrace();
					return null;
				}
			}
		};
		return callableTask;
	}
}
