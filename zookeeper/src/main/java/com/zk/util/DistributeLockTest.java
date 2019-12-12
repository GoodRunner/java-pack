package com.zk.util;

import java.util.concurrent.CountDownLatch;
//import org.I0Itec.zkclient.ZkClient;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2019-12-11 11:59
 */
public class DistributeLockTest {
//
//  public static void main(String[] args) {
//    // 通过 CountDownLatch 控制线程同时执行
//    CountDownLatch latch = new CountDownLatch(1);
//
//    // 开启3 个线程模拟分布式环境下每一个进程都是单独都zkClient
//    Thread t1 = new Thread(new TestThread(latch));
//    Thread t2 = new Thread(new TestThread(latch));
//    Thread t3 = new Thread(new TestThread(latch));
//
//    t1.start();
//    t2.start();
//    t3.start();
//
//    System.out.println("休眠1秒后执行。。。" + System.currentTimeMillis());
//    try {
//      Thread.sleep(1000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//    latch.countDown();
//  }
//}
//
//// 线程 尝试在zk上创建临时节点，创建成功则获得锁(执行权).
//class TestThread implements Runnable {
//
//  // 共享变量
//  private static Integer CNT = 0;
//  private ZkClient zkClient;
//  private  CountDownLatch countDownLatch;
//
//  public TestThread(CountDownLatch countDownLatch) {
//    this.countDownLatch = countDownLatch;
//  }
//
//  // 链接 zk
//  private void connect(){
//    String threadName = Thread.currentThread().getName();
//    try {
//      System.out.println(threadName + "执行等待...");
//      countDownLatch.await();
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//    System.out.println(threadName + "请求链接zk . " + System.currentTimeMillis());
//    zkClient = new ZkClient("127.0.0.1:2181");
//    System.out.println(threadName + "链接成功.");
//  }
//
//  @Override
//  public void run() {
//    connect();
//    String threadName = Thread.currentThread().getName();
//    // 竞争锁
//    while (true) {
//      try {
//        System.out.println(threadName + "开始竞争锁...");
//        // 创建zk临时节点
//        zkClient.createEphemeral("/zkLockRootPath","test");
//        System.out.println(threadName + "获得锁.");
//        // 获得锁后修改共享变量
//        CNT ++;
//        System.out.println(threadName + " 释放了锁 " + CNT);
//        zkClient.delete("/zkLockRootPath");
//        Thread.sleep(2000);
//      } catch (InterruptedException e) {
//        System.out.println(threadName + " 未获得锁，将重试！！！ ");
//      }
//    }
//
//  }

}