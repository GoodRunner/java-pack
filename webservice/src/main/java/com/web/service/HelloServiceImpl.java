package com.web.service;

import org.springframework.stereotype.Component;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "helloService", portName = "HelloPo"
        ,targetNamespace = "http://service.web.com/"
        ,endpointInterface = "com.web.service.HelloServiceImpl")
@Component
public class HelloServiceImpl implements HelloService {
  @Override
  public String say(@WebParam(name = "str") String str) {
    return null;
  }
}
