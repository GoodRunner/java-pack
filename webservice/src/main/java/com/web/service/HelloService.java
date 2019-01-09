package com.web.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(targetNamespace = "http://service.web.com/")
public interface HelloService {

  @WebMethod
  public String say(String str);

}
