package com.pet.sample.ms_b.innerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HystrixService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "fallback")
	public String comsumer() {
		try {
			Thread.sleep(5000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String result = restTemplate.getForObject("http://ms-a/v1/info/getName", String.class);
		System.out.println("result >>>>>> " + result);
		return result;
	}

	public String fallback() {
		return "fallback";
	}
}
