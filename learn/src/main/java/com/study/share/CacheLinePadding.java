package com.study.share;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-10-31 21:54
 */
public class CacheLinePadding {
  private static class T{
    public volatile long x = 0L;
  }
  public static T[] orr = new T[2];
  static {
    orr[0]= new T();
    orr[1]= new T();
  }
  public static void main(String[] args) throws Exception {
    Thread t1 = new Thread(()->{
      for (long i = 0; i < 1000_000L; i++) {
        orr[0].x = i;
      }
    });
    Thread t2 = new Thread(()->{
      for (long i = 0; i < 1000_000L; i++) {
        orr[1].x = i;
      }
    });
    final long start = System.nanoTime();
    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.println((System.nanoTime()-start)/100_000);
  }
}