package com.study.threadpool.mypool;

import java.util.Deque;

/**
 * @description: 线程节点类
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-10-21 17:31
 */
public class MyThreadNode extends Thread {

  private String name;

  private Runnable task;

  private TaskQueue queue;

  public MyThreadNode(Runnable task, String name, TaskQueue queue) {
    this.task = task;
    this.name = name;
    this.queue = queue;
  }

  @Override
  public void run() {

    /**
     *  想一下
     *  task != null   是提交任务的时候 核心线程还没满 直接创建线程给过来的 任务
     *  第二种情况是  任务从队列里边获取的
     */
    while (task != null || (task = queue.get()) != null) {
      task.run();
      task = null; // 不置空的话 这个任务一直在这里运行，因为 是 while
    }
  }
}