package com.study.threadpool.mypool;

import lombok.extern.slf4j.Slf4j;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: 自己的线程池
 * 当向线程池提交一个任务，
 * 如果线程池未达到核心线程数，则直接创建新线程执行任务
 * 如果达到核心线程数，则去队列排队
 *
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-10-21 14:26
 */
@Slf4j(topic = "MyThreadPool")
public class MyThreadPool {

  // 核心线程数量
  private int coreSize;

  // 存放线程的集合
  private Set<Thread> set;

  // 存放 任务 的队列。  这里简单点 队列的 最大最定死了
  private TaskQueue taskQueue;

  /**
   * 构造方法
   * @param coreSize 执行核心线程数量。
   */
  public MyThreadPool(int coreSize) {
    this.coreSize = coreSize;
    set = new HashSet<>();
    taskQueue = new TaskQueue(2); // 初始化队列
  }

  // 提交任务的方法
  public void submit(Runnable task) {
    /**
     * 如果当前线程池中线程没有达到定义的核心线程数
     *
     * 则直接创建线程运行
     */
    if (set.size() < coreSize) {
      log.debug("核心线程还没满， 直接创建线程执行");
      Thread thread = new MyThreadNode(task, "t-" + (set.size() + 1), this.taskQueue);
      set.add(thread);
      thread.start();
    } else {
      //已经达到核心线程数 之后的任务请求需要去排队
      log.debug("核心线程数达到上限， 这个任务应该去排队了");
      taskQueue.put(task);
    }
  }

}