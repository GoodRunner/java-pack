package com.study.lock;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-05-11 21:42
 */
public class TestDeadLock {

  private static String lock1 = "lock1";
  private static String lock2 = "lock2";

  public static void getLock1First()throws Exception {
    synchronized (lock1) {
      System.out.println("我拿到了锁1");
      Thread.sleep(1000);
      synchronized (lock2){
        System.out.println("我拿到了锁2");
      }

    }
  }

  public static void getLock2First()throws Exception {
    synchronized (lock2) {
      System.out.println("我拿到了锁2");
      Thread.sleep(1000);
      synchronized (lock1){
        System.out.println("我拿到了锁1");
      }

    }
  }

  private static class MyThread extends Thread{
    @Override
    public void run() {
      try {
        getLock1First();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    MyThread t = new MyThread();
    t.start();
    try {
      getLock2First();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}