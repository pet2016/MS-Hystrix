package com.pet.sample.ms_b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/v1")
public class LoadBalancerClientController {

  @Autowired
  LoadBalancerClient loadBalancerClient;

  @Autowired
  RestTemplate restTemplate;

  /**
   * 通过LoadBalancerClient的方式获取服务的地址和服务端口
   * 缺点：需要手工去编写服务，拼装url地址
   * @return 
   * @see 
   */
  @GetMapping("/loadBalancerClient")
  public String deposit() {
    ServiceInstance service = loadBalancerClient.choose("ms-a");
    String url = "http://" + service.getHost() + ":" + service.getPort() + "/v1/info/getName";
    System.out.println("url = " + url);
    return restTemplate.getForObject(url, String.class);
  }
  
  
  
}
