package com.message;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.message.rabbitmq.RabbitMQProducer;
import com.message.util.CallableTask;
import com.message.util.RunnableTasks;

@SpringBootApplication
public class MessagequeueApplication implements CommandLineRunner {

	@Autowired
	private RabbitMQProducer rabbitMQProducer;

	public static void main(String[] args) {
		SpringApplication.run(MessagequeueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("commandline runner method ..........");
		String[] taskNames = new String[5];
		
		ExecutorService executerService = Executors.newFixedThreadPool(10);
		
		Runnable task1 = RunnableTasks.getRunnableTaskWrite("AC1");
		Runnable task2 = RunnableTasks.getRunnableTaskWrite("AC2");
		Runnable task3 = RunnableTasks.getRunnableTaskWrite("AC3");
		Runnable task4 = RunnableTasks.getRunnableTaskWrite("AC4");
		Runnable task5 = RunnableTasks.getRunnableTaskWrite("AC5");
		
		executerService.execute(task1);
		executerService.execute(task2);
		executerService.execute(task3);
		executerService.execute(task4);
		executerService.execute(task5);

		taskNames[0] = "AC1";
		taskNames[1] = "AC2";
		taskNames[2] = "AC3";
		taskNames[3] = "AC4";
		taskNames[4] = "AC5";

		Runnable readTask = RunnableTasks.getRunnableTaskRead(taskNames);
		
		System.out.println("Initializing read task......");
		executerService.execute(readTask);

		Runnable alertTask = RunnableTasks.getAlertTask();
		executerService.execute(alertTask);
		
	}
}
