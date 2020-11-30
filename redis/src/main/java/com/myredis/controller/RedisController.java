package com.myredis.controller;

import com.myredis.bean.User;
import com.myredis.config.ApiIdempotent;
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
import java.util.List;
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

  @Autowired
  private RedisTemplate redisTemplate;

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

  @RequestMapping(value = "/send/list")
  public String pushList(@RequestParam(value = "str",required = true) String str,
                         @RequestParam(value = "list",required = false) String[] list) {
    System.out.println(str);
    System.out.println(list);
    return "sldfhgjdhsg";
  }


  /**
   * Redis + 注解 + 拦截器来实现接口幂等性校验
   * @param orderId
   * @return
   */
  @ApiIdempotent()
  @RequestMapping(value = "/idempotent")
  public String createOrder(HttpServletRequest request, String orderId) {

    String token = request.getHeader("token");

    try {
      Thread.sleep(3000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // 处理完就删除这个key
    redisTemplate.delete(token);

    return "halo!";
  }

}
