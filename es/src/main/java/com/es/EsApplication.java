package com.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @description: application
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2019-06-19 09:43
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class EsApplication {

  public static void main(String[] args) {
    SpringApplication.run(EsApplication.class);
  }

}