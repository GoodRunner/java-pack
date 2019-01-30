package com.myredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


@RestController
@RequestMapping("/data")
public class RedisController {

  @Autowired
  private JedisPool jedisPool;

  @RequestMapping("/redis")
  public String data(){

    Jedis jedis = jedisPool.getResource();
    long a = System.currentTimeMillis();
    try {
      for (int i = 0; i < 10000; i++) {
        jedis.lpush("key", "awr" + i);
        System.out.println(1);
        String str = jedis.brpoplpush("key", "wf", 3);
        System.out.println(2);
        jedis.lrem("wf", 2, str);
      }
    }finally {
      jedis.close();
    }
    long b = System.currentTimeMillis();
    return "{\"hello\":\"world \""+(b-a)+"\"}";
  }

}
