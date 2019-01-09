package com.myredis.controller;

import com.myredis.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class RedisController {

  @Autowired
  private TestService testService;

  @RequestMapping("/redis")
  public String data(){
    testService.getValue();
    return "asdasdad";
  }

}
