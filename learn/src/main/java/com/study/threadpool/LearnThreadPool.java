package com.study.threadpool;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-10-22 17:49
 */
@Slf4j(topic = "LearnThreadPool")
public class LearnThreadPool {

  static AtomicInteger atomicInteger = new AtomicInteger();

  public static void main(String[] args) {

    ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(0,Integer.MAX_VALUE,5,
            TimeUnit.SECONDS,
            new SynchronousQueue<>(),
            (r) -> {
              return new Thread(r,"t-" + atomicInteger.incrementAndGet());
            },
            new ThreadPoolExecutor.AbortPolicy());

    for (int i = 0; i < 10000; i++) {
      threadPoolExecutor.submit(new MyTesk(i + 1));
    }

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

  static class MyTesk implements Runnable {

    private int teskNum;

    public MyTesk(int teskNum) {
      this.teskNum = teskNum;
    }

    @Override
    public void run() {
      log.debug("线程名称：{},正在执行：{}",Thread.currentThread().getName(), teskNum);
      try {
        Thread.currentThread().sleep(3003);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      log.debug("task {} 执行 完毕", teskNum);
    }
  }

}