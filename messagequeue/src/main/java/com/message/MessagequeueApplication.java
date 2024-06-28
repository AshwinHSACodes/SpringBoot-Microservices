package com.message;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.message.rabbitmq.RabbitMQProducer;
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
		
		Executor executerService = Executors.newFixedThreadPool(5);
		
		Runnable task1 = RunnableTasks.getRunnableTask("AC1");
		Runnable task2 = RunnableTasks.getRunnableTask("AC2");
		Runnable task3 = RunnableTasks.getRunnableTask("AC3");
		Runnable task4 = RunnableTasks.getRunnableTask("AC4");
		Runnable task5 = RunnableTasks.getRunnableTask("AC5");
		
		executerService.execute(task1);
		executerService.execute(task2);
		executerService.execute(task3);
		executerService.execute(task4);
		executerService.execute(task5);

	}
}
