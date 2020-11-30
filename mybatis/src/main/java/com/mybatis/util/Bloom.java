package com.mybatis.util;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-07-29 20:54
 */
public class Bloom {

  public static String lock_pre = "my_lock_pre";

  public static void main(String[] args) {

    int i = 0;

    synchronized (lock_pre) {
      i += 1;
    }
  }

}