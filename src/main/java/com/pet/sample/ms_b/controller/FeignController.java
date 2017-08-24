package com.pet.sample.ms_b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.sample.ms_b.innerservice.Service;

@RestController
@RequestMapping("/v1")
public class FeignController {

  @Autowired
  Service service;

  @GetMapping("/feign")
  public String test() {
    return service.test();
  }
  
}
