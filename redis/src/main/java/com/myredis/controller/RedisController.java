package com.myredis.controller;

import com.myredis.bean.User;
import com.myredis.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/data")
public class RedisController {

  @Autowired
  private TestService testService;

  @RequestMapping("/redis")
  public String data() throws Exception{

    String str = testService.getValue("78");

    return str;
  }

  @RequestMapping(value = "/push",produces = "application/json;charset=UTF-8")
  public String pushData(@RequestBody User hhu) {
    System.out.println("skgkjdhfg");
    return "sldfhgjdhsg";
  }

}
