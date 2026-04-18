package com.testOne.basicTesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BasicTestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicTestingApplication.class, args);
	}

}
