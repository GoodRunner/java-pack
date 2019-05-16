package com.dubbo.service;

import com.dubbo.common.IService;

public class MyService implements IService {
  @Override
  public String sayHello(String str) {
    return str + "world!";
  }
}
