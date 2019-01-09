package com.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class AuthApplication {

  public static void main(String[] args) {
    SpringApplication.run(AuthApplication.class, args);
  }

  @RequestMapping("/")
  public String index(){
    return "client";
  }

  @RequestMapping("/callback")
  public String callBack(Model m){
    System.out.println(m);
    return "call_back";
  }

}
