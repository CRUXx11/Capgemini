package io.carwash.customers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;


@SpringBootApplication
@EnableEurekaClient
//@EnableSwagger2
public class CustomersApplication {
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
//    @Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.any())
//				.build();
//	}

	public static void main(String[] args) {
		SpringApplication.run(CustomersApplication.class, args);
	}

}
