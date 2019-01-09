package com.myredis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class TestService {

  @Autowired
  private RedisTemplate redisTemplate;

  public String getValue(){

    redisTemplate.opsForValue().set("aaa", "hello world");

    System.out.println(redisTemplate.opsForValue().get("aaa"));

    return "kahkhsf";
  }

}
