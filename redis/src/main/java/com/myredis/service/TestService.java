package com.myredis.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TestService {

  @Cacheable(value = "practiseReport", key = "'haha_'+#id")
  public String getValue(String id){

    HashMap map = new HashMap();

    map.put("","");

    System.out.println("进来了");
    return "{\"hello\":\"world}";
  }



}
