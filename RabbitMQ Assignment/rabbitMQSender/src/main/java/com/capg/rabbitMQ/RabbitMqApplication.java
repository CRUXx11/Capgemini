package com.capg.rabbitMQ;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capg.rabbitMQ.config.RabbitMQConfig;
import com.capg.rabbitMQ.models.Product;

@SpringBootApplication
public class RabbitMqApplication implements CommandLineRunner {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(RabbitMqApplication.class, args);
	}
	public void run(String... args) throws InterruptedException{
		Product product = new Product();
		product.setProductId(100);
		product.setName("Laptop");
		product.setQuantity(10);
		
		System.out.println("Sending Message");
		rabbitTemplate.convertAndSend(RabbitMQConfig.topicExchangeName,"message_routing_key",product);
		System.out.println("Mesasage sent successfully");
	}

}
