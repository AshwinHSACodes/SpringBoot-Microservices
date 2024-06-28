package com.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.message.rabbitmq.RabbitMQProducer;

@RestController
@RequestMapping("produce")
public class MessageProducerController {

	@Autowired
	RabbitMQProducer rabbitMQProducer;
	
	@GetMapping("/message/{msg}")
	public String produceMessage(@PathVariable("msg") String msg) {
		
		rabbitMQProducer.sendMessage("Connected to RabbitMQ!!!!!!!!!!!!!!");
		
		return "Message sent to queue";
	}
}
