
package com.pet.sample.ms_b.innerservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("ms-a")
public interface Service {

  @GetMapping("/v1/info/getName")
  public String test();
  
}
