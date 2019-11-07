package com.mq.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {

  @Autowired
  private KafkaTemplate<String, Object> kafkaTemplate;

  @RequestMapping("/hello")
  public Map hello() {
    Map map = new HashMap();
    map.put("hello","world");
    return map;
  }

  @RequestMapping("/send")
  public String send(String message) {
    kafkaTemplate.send("mytopic","这是一条测试消息");
    return "hello";
  }

}