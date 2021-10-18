package com.century.bykemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BykeMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BykeMicroserviceApplication.class, args);
	}

}
