package com.capg.rabbitMQ.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Queue;

@Component
public class RabbitMQConfig {

	public static final String topicExchangeName="message_queue_exchange";
	public static final String queueName="message_queue";
	
	@Bean
	Queue Queue() {
		return new Queue(queueName,false);
	}
	@Bean
	TopicExchange exchange() {
		return new TopicExchange(topicExchangeName);
	}
	@Bean
	Binding binding(Queue Queue,TopicExchange exchange) {
		return BindingBuilder.bind(Queue).to(exchange).with("message_routing_key");
	}
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory=new CachingConnectionFactory("localhost");
	connectionFactory.setPort(5672);
	connectionFactory.setUsername("guest");
	connectionFactory.setPassword("guest");
	return connectionFactory;
	}
	}
	

