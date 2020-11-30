package com.study.share;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-10-25 11:53
 */
public class TestCompile {

  static int b = 1;

  volatile  int a = 34;

  public static void main(String[] args) {
    TestCompile testCompile = new TestCompile();testCompile.testsyn();

  }

  public void testsyn() {
    byte b = (byte)193;
    System.out.println(b);
  }

}