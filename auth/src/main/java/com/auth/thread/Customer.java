package com.auth.thread;

/**
 * @description: 客人类， 要吃包子，熟了之后才能吃包子
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-04-24 10:24
 */
public class Customer extends Thread {

  private BaoZi baozi;

  public Customer(BaoZi baozi) {
    this.baozi = baozi;
  }

  @Override
  public void run() {
    System.out.println("客人想吃包子");
    baozi.eat();
  }
}