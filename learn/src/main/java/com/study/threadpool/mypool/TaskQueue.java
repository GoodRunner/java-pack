package com.study.threadpool.mypool;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 我自己线程池的排队队列
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-10-21 14:39
 */
@Slf4j(topic = "TaskQueue")
public class TaskQueue {

  // 队列的大小
  private int queueSize;
  // 存放元素 的 双向队列
  Deque<Runnable> deque = new ArrayDeque();

  //构造方法
  public TaskQueue(int queueSize) {
    this.queueSize = queueSize;
  }
  // 一个锁
  ReentrantLock lock = new ReentrantLock();
  // 一个 条件队列 如果队列满的话 再放的线程阻塞在这里
  Condition full = lock.newCondition();
  // 一个 条件队列  如果队列是空的，  再取的线程阻塞在这里
  Condition empty = lock.newCondition();

  public void put(Runnable task) {

    /**
     * 添加元素
     * 判断是否到达上限
     */

    lock.lock();
    try {

      while (deque.size() == queueSize) {
        try {
          log.debug("放任务 排队达到上限， 等待");
          full.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      // 能进到这边则表示 队列还能存
      log.debug("放任务  排队还没有到上限， 直接入队排队");
      deque.addLast(task);
      // 想一下  队列已经放了一个，但是在取的 方法中 取的线程还在等待，所以需要叫醒 那个取的线程     取的方法中也有一个 这个逻辑，这个是典型的生产者消费者模型
      empty.signal();
    } finally {
      lock.unlock();
    }
  }
  // 取任务
  public Runnable get() {
    lock.lock();
    try {
      // 判断队列中是否有个人排队
      while (deque.isEmpty()) {
        // 没有排队 则取等待
        log.debug("取任务 队列中没任务， 等待");
        empty.await();
      }
      // 代码到这里则是能获取一个任务
      log.debug("取任务 队列中有任务， 获取任务");
      Runnable r = deque.removeFirst();

      // 想一下  队列已经取走了一个，但是在put 方法中 放的线程还在等待，所以需要叫醒 那个放的线程

      full.signal();

      return r;
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
    return null;
  }

}