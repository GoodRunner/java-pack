package com.myredis.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TestService {

  @Cacheable(value = "practiseReport", key = "'haha_'+#id")
  public String getValue(String id){
    System.out.println("进来了");
    return "{\"hello\":\"world}";
  }

}
