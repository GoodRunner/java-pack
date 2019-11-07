package com.mybatis.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @description: s
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2019-07-23 17:02
 */
public class Md5 {

  /**
   * md5加密.
   * @param plainText 待加密字符串
   * @return 加密后32位字符串
   */
  public static String getMd5(String plainText) {

    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(plainText.getBytes());
      byte[] b = md.digest();
      int i;
      StringBuffer buf = new StringBuffer("");
      for (int offset = 0; offset < b.length; offset++) {
        i = b[offset];
        if (i < 0) {
          i += 256;
        }
        if (i < 16) {
          buf.append("0");
        }
        buf.append(Integer.toHexString(i));
      }
      // 32位加密
      return buf.toString();
    } catch (NoSuchAlgorithmException e) {
      return null;
    }
  }

}