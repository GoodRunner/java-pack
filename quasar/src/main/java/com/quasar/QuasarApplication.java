package com.quasar;

import javax.annotation.meta.Exclusive;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @description: main entry
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2019-05-16 13:56
 */
@SpringBootApplication
@EnableAsync

public class QuasarApplication {

  public static void main(String[] args) {
    SpringApplication.run(QuasarApplication.class, args);
  }

}