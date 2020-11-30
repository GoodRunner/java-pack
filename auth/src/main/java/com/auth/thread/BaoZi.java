package com.auth.thread;

/**
 * @description: 包子类，
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-04-24 10:20
 */
public class BaoZi {

  /**
   * 包子是否熟了.
   */
  private boolean cooked = false;

  public boolean isCooked() {
    return cooked;
  }

  public void setCooked(boolean cooked) {
    this.cooked = cooked;
  }

  /**
   * 蒸包子.
   */
  public void steam() {

    synchronized(this) {
      System.out.println("蒸包子需要10秒钟。。。");
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      // 蒸熟.
      System.out.println("包子蒸好了");
      this.cooked = true;
      System.out.println("通知客人吃");
      this.notify();
    }
  }

  /**
   * 吃包子方法. 当包子熟了之后才能吃.
   * @return
   */
  public  void eat() {

    synchronized(this) {
      while (!cooked) {
        // 如果没熟就一直循环等待.
        try {
          System.out.println("包子没熟请客人等待...");
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      // 跳出循环之后 就代表熟了
      System.out.println(cooked + "包子真好吃！");
    }
  }


}