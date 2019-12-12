package com.zk.service;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2019-12-11 16:08
 */
public class OrderSrvice implements Runnable {

  private ZookeeperDistrbuteLock lock = new ZookeeperDistrbuteLock();

  private  static int couunt = 0;

  @Override
  public void run() {

  }

//  @Override
//  public void run() {
//
//    try {
//      lock.getLock();
//      //Thread.sleep(1000);
//      couunt++;
//      System.out.println("当前累加：" + couunt);
//
//    } catch (Exception e) {
//      e.printStackTrace();
//    }finally {
//      lock.unLock();
//    }
//  }

//  public static void main(String[] args) {
//
//    for (int i = 0; i < 15; i++) {
//      new Thread(new OrderSrvice()).start();
//    }
//
//  }

}