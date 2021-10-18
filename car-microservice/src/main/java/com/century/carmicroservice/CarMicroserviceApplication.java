package com.century.carmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CarMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarMicroserviceApplication.class, args);
	}

}
