package com.mybatis.util;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-04-23 21:25
 */
public class ThreadLocalOOM {

  private static int TASK_LOOP_SIZE = 500;

  static ThreadPoolExecutor pool = new ThreadPoolExecutor(5,5,5, TimeUnit.MINUTES,new LinkedBlockingQueue<>());
  static class LocalVar{
    private byte[] a = new byte[1024 * 1024 * 5]; /* 5M大小数组 */
  }

  final static ThreadLocal<LocalVar> localVar = new ThreadLocal<>();

  public static void main(String[] args) {
    for (int i = 0; i < TASK_LOOP_SIZE; i++) {
      pool.execute(new Runnable() {
        @Override
        public void run() {
          localVar.set(new LocalVar());
//          new LocalVar();
          System.out.println("use local var");
        }
      });
    }
  }

}