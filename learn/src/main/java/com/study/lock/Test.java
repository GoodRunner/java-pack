package com.study.lock;

import com.google.common.util.concurrent.RateLimiter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.crypto.Data;
import org.openjdk.jol.info.ClassLayout;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-08-30 14:27
 */
public class Test {

  private static Test t = new Test();

  private int i = 0;

  private Test(){}

  public static Test getInstence() {

    return t;

  }

  public int getMyi(){
    return i;
  }

  public void doSomeThing() {
    i++;
    Double v = Math.random() * 10;
    try {
      Thread.sleep(v.intValue());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Test instence = Test.getInstence();



    Thread thread = new Thread(
            () -> {
              for (int i = 0; i < 100 ; i++) {
                instence.doSomeThing();
              }
            }
    );

    Thread thread2 = new Thread(
            () -> {
              for (int i = 0; i < 100 ; i++) {
                instence.doSomeThing();
              }
            }
    );

    Thread thread3 = new Thread(
            () -> {
              for (int i = 0; i < 100 ; i++) {
                instence.doSomeThing();
              }
            }
    );

    for (int i = 0; i < 100; i++) {
      instence.doSomeThing();
    }


    try {
      thread.start();
      thread.join();
      thread2.start();
      thread2.join();
      thread3.start();
      thread3.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(instence.getMyi());

  }
}