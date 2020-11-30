package com.study.lock;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-10-17 11:16
 */
@Slf4j
public class SynchronizedDemo {

  boolean flag = true;

  public void  test() {
    log.info("=========test start");
    while (flag) {

    }
    log.info("=========test end");
  }

  public static void main(String[] args) {

    SynchronizedDemo synchronizedDemo = new SynchronizedDemo();

    Runnable r = () -> synchronizedDemo.test();

    new Thread(r, "my-thread-9999999");

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    

  }

}