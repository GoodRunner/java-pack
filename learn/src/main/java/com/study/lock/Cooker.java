package com.study.lock;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-04-29 19:46
 */
public class Cooker extends Thread {

  private CountDownLatch downLatch;

  public Cooker(CountDownLatch downLatch) {
    this.downLatch = downLatch;
  }

  @Override
  public void run() {
    System.out.println("厨师开始Cooking 开始制作 ...");
    try {
      System.out.println("厨师开始第一阶段制作。。。");
      Thread.sleep(3000);
      this.interrupt();
      System.out.println("厨师开始第er阶段制作。。。");
      Thread.sleep(5000);
      System.out.println("制作完成");
      downLatch.countDown();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }



  }
}