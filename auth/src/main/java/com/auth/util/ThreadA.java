package com.auth.util;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-04-24 09:46
 */
public class ThreadA {

  public static void main(String[] args) {
    ThreadB tb = new ThreadB();
    tb.start();
    System.out.println("b is start ...");

    synchronized (tb) {
      System.out.println("Waiting for b to complete...");
      try {
        tb.wait();
        System.out.println("Completed.  Now back to main thread");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("Main Total is :" + tb.total);
  }
}

class ThreadB extends Thread {
  int total = 1;

  @Override
  public void run() {
    // ThreadB 获取 这个对象的锁
    synchronized (this) {
      System.out.println("ThreadB is running");
      for (int i = 0; i < 5; i++) {
        try {
          Thread.sleep(1500L);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        total += total;
        System.out.println("tb total is :" + total);
      }
      System.out.println("here");
    }
    System.out.println("oooooo------oooooo");
    notifyAll();
  }
}

