package com.myredis.service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-04-30 10:08
 */
public class Bullet extends Thread{

  private AtomicInteger my_num = new AtomicInteger();

  @Override
  public void run() {

    int get = my_num.incrementAndGet();
    System.out.println(this.getName() + " num is :" + get);

  }
}