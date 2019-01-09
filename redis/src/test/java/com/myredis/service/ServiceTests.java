package com.myredis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestService.class})
public class ServiceTests {

  @Autowired
  private TestService testService;

  @Test
  public void redisTest(){

    String str = testService.getValue();

    System.out.println(str);

  }

}
