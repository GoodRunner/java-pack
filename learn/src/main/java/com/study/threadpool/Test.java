package com.study.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-05-11 09:33
 */
public class Test {

  public static void main(String[] args) {

    ThreadPoolExecutor pool = new ThreadPoolExecutor(2,4,1, TimeUnit.MINUTES,
            new ArrayBlockingQueue<>(6), new ThreadPoolExecutor.DiscardPolicy());


    // 30个
    for (int i = 0; i < 11; i++) {
      MyThread t = new MyThread();
      t.setName("第-" + i);
      pool.execute(t);
    }

    System.out.println("ActiveCount:" + pool.getActiveCount());
    System.out.println("CorePoolSize:" + pool.getCorePoolSize());
    System.out.println("LargestPoolSize:" + pool.getLargestPoolSize());
    System.out.println("MaximumPoolSize:" + pool.getMaximumPoolSize());
    System.out.println("PoolSize:" + pool.getPoolSize());
    System.out.println("QueueSize:" + pool.getQueue().size());
    pool.shutdown();
  }

  static class MyThread extends Thread {
    @Override
    public void run() {
      try {
        Thread.sleep(6000);
        System.out.println(this.getName() + "执行完！");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}