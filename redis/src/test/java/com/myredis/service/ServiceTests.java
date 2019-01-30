package com.myredis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTests {

//  @Autowired
//  private RedisTemplate redisTemplate;

  @Test
  public void testTime() {
//
//    for (int i = 0; i < 1000; i++) {
//      redisTemplate.opsForList().leftPush("key", "vic" + i);
//    }
//    long total = 0l;
//    while (true) {
//      long start = System.currentTimeMillis();
//      String str = (String)redisTemplate.opsForList().rightPopAndLeftPush("key" , "bak", 3, TimeUnit.SECONDS);
//      if (null == str)
//        break;
//      redisTemplate.opsForList().remove("bak", 1 , str);
//      long end = System.currentTimeMillis();
//      total += end-start;
//    }
//
//    System.out.println(total);

  }

}
