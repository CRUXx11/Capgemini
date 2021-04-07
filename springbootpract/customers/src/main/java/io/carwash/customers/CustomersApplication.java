package io.carwash.customers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
public class CustomersApplication {

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer(){
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**")
//						.allowedMethods("GET","POST","PUT","DELETE")
//						.allowedHeaders("*")
//						.allowedOrigins("http://localhost:8080/")
//						.allowCredentials(true);
//			}
//		};
//	}

	public static void main(String[] args) {
		SpringApplication.run(CustomersApplication.class, args);
	}

}
