package com.study.lock;

import java.util.concurrent.CountDownLatch;

/**
 * @description: 工人类.
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-04-29 19:39
 */
public class Worker implements Runnable {

  CountDownLatch downLatch;

  public Worker(CountDownLatch downLatch) {
    this.downLatch = downLatch;
  }

  @Override
  public void run() {
    System.out.println("I am Doing Thing ...");
    try {

      Thread.sleep(3000);

      downLatch.countDown();

    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}