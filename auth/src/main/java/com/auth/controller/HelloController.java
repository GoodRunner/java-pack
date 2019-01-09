package com.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class HelloController {

  @RequestMapping("/hello")
  public ResponseEntity<Map> hello(){
    Map map = new HashMap<>();
    map.put("hello","world!");
    return ResponseEntity.ok(map);
  }

}
