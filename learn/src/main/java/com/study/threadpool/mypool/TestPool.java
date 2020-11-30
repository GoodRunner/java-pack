package com.study.threadpool.mypool;

/**
 * @description: 测试类
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-10-21 14:41
 */
public class TestPool {

  public static void main(String[] args) {

    MyThreadPool myThreadPool = new MyThreadPool(2);

    // 向线程池中提交任务

    for (int i = 0; i < 8; i++) {

      myThreadPool.submit(() -> {
        try {
          Thread.sleep(3000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("this is a task log .....");
      });

    }

  }

}