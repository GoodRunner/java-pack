package com.study.lock;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-12-03 17:49
 */

public class Thread01 {
  public static void main(String[] args) throws InterruptedException {
    AddThread add = new AddThread();
    DecThread dec = new DecThread();
    Thread t1 = new Thread(add);
    Thread t2 = new Thread(dec);
    t1.start();
    t2.start();

    t1.join();
    t2.join();

    System.out.println(Counter.count);
  }
}

class Counter {
  public static final Object lock = new Object();
  public static int count = 0;
}

class AddThread implements Runnable {
  @Override
  public void run() {
    for (int i=0; i<1000000; i++) {
      synchronized(Counter.lock) {
        Counter.count += 1;
      }
    }
  }
}

class DecThread implements Runnable {
  @Override
  public void run() {
    for (int i=0; i<1000000; i++) {
      synchronized(Counter.lock) {
        Counter.count -= 1;
      }
    }
  }
}