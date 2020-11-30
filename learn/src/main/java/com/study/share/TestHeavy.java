package com.study.share;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-10-27 23:36
 */
@Slf4j(topic = "TestHeavy")
public class TestHeavy {

  private static Object key = new Object();

  private static volatile boolean money = false;

  public static void main(String[] args) {

    new Thread(() -> {
      synchronized (key) {
        if (!money) {
          try {
            key.wait(); // 丢掉钥匙  相当于释放锁
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        if (money) {
          log.info("有钱了  加班工作。");
        }

      }
    },"t99").start();

    for (int i = 0; i < 10 ; i++) {

      new Thread(() -> {
        synchronized (key) {
          log.info("其他员工工作了");
        }
      },"t" + i).start();

    }

    // 老板
    new Thread(() -> {
      synchronized (key) {
        log.info("送钱来了");
        money = true;
        key.notify();
      }
    },"老板").start();

  }

}