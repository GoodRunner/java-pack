package com.myredis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTests {

//  @Autowired
//  private RedisTemplate redisTemplate;

  @Test
  public void testTime() {

    HashMap<String, String> map = new HashMap(16);
    for (int i = 0; i < 9; i++) {
      map.put(i + "","hhh" + i);
    }
    //System.out.println(3 |= 3 >>> 1);


  }

}
