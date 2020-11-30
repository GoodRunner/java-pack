package com.auth.thread;

/**
 * @description: 服务员类，催包子蒸熟.
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-04-24 11:03
 */
public class Waiter extends Thread {

  private BaoZi baozi;

  public Waiter(BaoZi baozi) {
    this.baozi = baozi;
  }

  @Override
  public void run() {
    baozi.steam();
  }
}