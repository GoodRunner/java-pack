package com.web.config;

import com.web.service.HelloService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {

  @Autowired
  private Bus bus;

  @Autowired
  private HelloService helloService;

  @Bean
  public Endpoint endpoint() {
    Endpoint endpoint =  new EndpointImpl(bus, helloService);
    endpoint.publish("/hello");
    return endpoint;
  }

}
