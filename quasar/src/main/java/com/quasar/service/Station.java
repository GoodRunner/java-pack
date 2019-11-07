package com.quasar.service;

/**
 * @description: 车站  售票
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2019-05-16 14:23
 */
public class Station extends Thread{

  //100 张票
  static int tick = 100;

  /**
   * 设置线程名称
   * @param name
   */
  public Station(String name) {
    super(name);
  }

  @Override
  public void run() {
    while (tick > 0) {
      //synchronized ()
    }
  }

  synchronized public void getValue() {}
}