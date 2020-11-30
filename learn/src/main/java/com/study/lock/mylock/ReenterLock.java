package com.study.lock.mylock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-10-10 16:20
 */
public class ReenterLock {

  volatile int status = 0;

  public static void main(String[] args) {

    Object obj = new Object();

    Map<String, Object> map = new HashMap<>();

    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(32);

    ReentrantLock reentrantLock = new ReentrantLock();

    reentrantLock.lock();

    AtomicInteger in = new AtomicInteger();

    in.incrementAndGet();


    LongAdder longAdder = new LongAdder();

    longAdder.add(2);

    Long a = 2147483650L;

    System.out.println(a.intValue());

    String lock = "sfdfgh";

    ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    ReentrantReadWriteLock.ReadLock w = reentrantReadWriteLock.readLock();

    w.lock();

    int EXCLUSIVE_MASK = (1 << 16) - 1;

    System.out.println("================== " + EXCLUSIVE_MASK);

    System.out.println(1 & EXCLUSIVE_MASK);

    StampedLock stampedLock = new StampedLock();
    // 尝试去获取锁
    long stampe = stampedLock.tryOptimisticRead();



    synchronized (lock) {
      System.out.println();
    }
  }
}