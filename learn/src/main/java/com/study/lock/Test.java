package com.study.lock;

import com.google.common.util.concurrent.RateLimiter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.crypto.Data;
import org.openjdk.jol.info.ClassLayout;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-08-30 14:27
 */
public class Test {

  public static User u = new User();

  static Thread t1;

  public static void main(String[] args) {

    SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    try {
      Date date = sdft.parse("2020-08-26 12:09:20");
      System.out.println(date.after(new Date()));
    } catch (ParseException e) {
      e.printStackTrace();
    }

    //System.out.println(Integer.toHexString(u.hashCode()));
//    System.out.println("还未启动  ---  无锁");
//    System.out.println(ClassLayout.parseInstance(u).toPrintable());
//    t1 = new Thread(){
//      @Override
//      public void run() {
//        testLock();
//      }
//    };
//    t1.setName("t1");
//    t1.start();

    //AccountNormal account = new AccountNormal(1000);
    //AccountSync account = new AccountSync(1000);
//    AccountCas account = new AccountCas(1000);
//    test(account);

    Object lock = new Object();

    int N = 10;

    Thread[] threads = new Thread[N];

    for (int i = 0; i < N; ++i) {

      threads[i] = new Thread() {
        @Override
        public void run() {
          synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " get sync lock!");
            try {
              Thread.sleep(200);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
      };

    }
    // main 线程得到 lock
    synchronized (lock) {
      for (Thread thread : threads) {
        thread.start();
        try {
          Thread.sleep(200);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }



  }

  //测试 存取钱
  static void test(Account acount){

    List<Thread> list = new ArrayList<>();

    for (int i = 0; i < 500; i++) {
      list.add(new Thread(){
        @Override
        public void run() {
          acount.acquire(1);
        }
      });
    }
    //启动
    for (Thread thread : list) {
      thread.start();
    }

    System.out.println(acount.query());

  }



  public static void testLock () {
    synchronized (u) {
      System.out.println(Integer.toHexString(Thread.currentThread().hashCode()));
      System.out.println("tName:" + Thread.currentThread().getName());
      System.out.println(ClassLayout.parseInstance(u).toPrintable());
    }
  }
}