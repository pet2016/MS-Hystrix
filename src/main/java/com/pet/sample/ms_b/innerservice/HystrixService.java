package com.pet.sample.ms_b.innerservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ms-a", fallback = HystrixFallBack.class)
public interface HystrixService {
	@GetMapping("/v1/info/getName")
	public String getName();
}

@Component
class HystrixFallBack implements HystrixService{
	@Override
	public String getName() {
		return "feign fallback";
	}
}