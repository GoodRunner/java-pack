package com.study.share;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-10-28 09:47
 */
public class TestStringBuffer {

  public static void main(String[] args) {

  }

  public String constStr(String s1, String s2, String s3) {
    StringBuffer sb = new StringBuffer();
    sb.append(s1);
    sb.append(s2);
    sb.append(s3);
    return sb.toString();
  }

}