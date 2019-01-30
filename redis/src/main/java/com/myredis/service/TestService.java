package com.myredis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TestService extends Thread{

//  @Autowired
//  private RedisTemplate redisTemplate;

  @Override
  public void run() {
//    redisTemplate.opsForList().rightPopAndLeftPush("gy", "hh",10, TimeUnit.SECONDS);
    System.out.println("afa");
  }
}
