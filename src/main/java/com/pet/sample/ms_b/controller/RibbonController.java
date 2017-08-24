
package com.pet.sample.ms_b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/v1")
public class RibbonController {

  @Autowired
  RestTemplate restTemplate;
  
  @GetMapping("/ribbon")
  public String  test(){
    //RestTemplate 实例化时需要加@LoadBalanced
    return restTemplate.getForObject("http://ms-a/v1/info/getName", String.class);    
  }
  
}
