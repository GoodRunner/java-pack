package com.zk.service;

import java.util.concurrent.CountDownLatch;
//import org.I0Itec.zkclient.IZkDataListener;
//import org.I0Itec.zkclient.ZkClient;

/**
 * @description: 利用zkClient 实现分布式锁.
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2019-12-11 14:17
 */
public class ZookeeperDistrbuteLock implements Lock {
//
//  private static final String CONNECT_ADDRES = "127.0.0.1:2181";
//  protected ZkClient zkClient = new ZkClient(CONNECT_ADDRES);
//  protected static final String PATH = "/lock";
//
//  private CountDownLatch countDownLatch = null;
//
//  @Override
//  public void getLock() {
//    String threadName = Thread.currentThread().getName();
//    // tryLock() 创建zk临时节点 如果创建成功返回true 否则返回false
//    if (tryLock()) {
//      System.out.println(threadName + "获取到锁的资源 get lock");
//    } else {
//      // 等待
//      waitLock();
//      // 重写获取锁的资源
//      getLock();
//    }
//  }
//
//  @Override
//  public void unLock() {
//
//    if (zkClient != null) {
//      zkClient.delete(PATH);
//    }
//    System.out.println("释放锁的资源..");
//  }
//
//  protected boolean tryLock() {
//    try {
//      zkClient.createEphemeral(PATH);
//      return true;
//    } catch (Exception e) {
//      //e.printStackTrace();
//      // 创建有可能出错  报节点已经存在的错误.
//      return false;
//    }
//  }
//
//  protected void waitLock() {
//    IZkDataListener zkDataListener = new IZkDataListener() {
//      // 节点被删除的时候 事件通知
//      public void handleDataDeleted(String path) throws Exception {
//        // 唤醒被等待的线程
//        if (countDownLatch != null) {
//          countDownLatch.countDown();
//          System.out.println("删除节点.....");
//        }
//      }
//      public void handleDataChange(String path, Object data) throws Exception {}
//    };
//    // 注册到zkclient进行监听
//    zkClient.subscribeDataChanges(PATH, zkDataListener);
//    if (zkClient.exists(PATH)) {
//      countDownLatch = new CountDownLatch(1);
//      try {
//        countDownLatch.await();
//      } catch (Exception e) {
//        // TODO: handle exception
//      }
//    }
//    // 删除监听
//    zkClient.unsubscribeDataChanges(PATH, zkDataListener);
//  }
}