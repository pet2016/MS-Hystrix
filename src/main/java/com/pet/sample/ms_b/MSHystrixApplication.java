package com.pet.sample.ms_b;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

//@SpringBootApplication
//@EnableDiscoveryClient
//@EnableCircuitBreaker
@SpringCloudApplication
public class MSHystrixApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MSHystrixApplication.class, args);
	}
}
