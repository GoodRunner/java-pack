package com.study.cond;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 小笼包
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-04-30 21:45
 */
public class XiaoLongBao {

  /**
   *  是否熟了
   *
   */
  private boolean cooked = false;

  private ReentrantLock lock = new ReentrantLock();

  private Condition ckCond = lock.newCondition();

  public void steam() {
    lock.lock();
    System.out.println("开始蒸包子。。。");
    try {
      Thread.sleep(3000);
      System.out.println("包子好了");
      cooked = true;
      ckCond.signal();

    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public void eat() {
    lock.lock();

    try {
      while (!this.cooked) {
        System.out.println("想吃但是没熟。。。");
        try {
          System.out.println("等等 再吃。。。");
          ckCond.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    } catch (Exception e) {

    }finally {
      lock.unlock();
    }

    System.out.println("小笼包真好吃：" + this.cooked);

  }

}