package com.study.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-04-27 11:14
 */
public class MyLock {

  public static void main(String[] args) {
    //ReentrantReadWriteLock reLock = new ReentrantReadWriteLock();
    ReentrantLock lock = new ReentrantLock();
//    LockSupport.park();



    CountDownLatch downLatch = new CountDownLatch(2);

    Cooker ck = new Cooker(downLatch);

    Worker wk = new Worker(downLatch);

    ExecutorService pool = Executors.newFixedThreadPool(5);

    pool.execute(ck);
    pool.execute(wk);

    try {
      System.err.println("咱在这里？");
      downLatch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("哈哈  到这里了 。。。");
    pool.shutdown();
  }

}