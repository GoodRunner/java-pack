package com.mybatis.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.Mac;

import javax.crypto.spec.SecretKeySpec;

//import org.apache.commons.codec.binary.Base64;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.util.StringUtils;

public class ApiMac {
  private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
  private static final String CHARSET_NAME = "UTF-8";
  private Mac mac;

  public ApiMac(String appKey) {
    try {
      byte[] appKeyBytes = appKey.getBytes(CHARSET_NAME);
      SecretKeySpec signingKey = new SecretKeySpec(appKeyBytes, HMAC_SHA1_ALGORITHM);
      mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
      mac.init(signingKey);
    } catch (Exception e) {
      throw new RuntimeException("Failed to initialize HMAC-SHA1", e);
    }
  }

  public String sign(String data) {
    String hash;
    try {
      byte[] rawHash = mac.doFinal(data.getBytes(CHARSET_NAME));
      hash = Base64.encodeBase64String(rawHash);
    } catch (Exception e) {
      throw new RuntimeException("Failed to compute hash", e);
    } finally {
      mac.reset();
    }
    return hash;
  }

  /**
   *
   * @param key 加密对key
   * @param data 需要加密的串
   * @return
   */
  public String getSign(String key, String data) {
    ApiMac api = new ApiMac(key);
    String result = api.sign(data);
    return result;
  }

  private static String replaceComma(int pageNo, int pageSize) {

    String[] stus = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14"};
    int pageStuNum = 0;
    StringBuffer sb = new StringBuffer();
    for (String s : stus) {
      pageStuNum++;
      if (pageStuNum > (pageNo -1 ) * pageSize
              && pageStuNum <= pageNo * pageSize) {
        sb.append(s);
        sb.append("...");
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    // 59a0e77c3ec04e8db70c4402ef0e9f47   生产环境
    // 2cedf018dfe87547a06719b9ef02fc91   测试环境
    ApiMac api = new ApiMac("59a0e77c3ec04e8db70c4402ef0e9f47");

    String syt = api.sign("/usercenter/v2/students/search/code?studentCode=BJ1120569921");

    //System.out.println(Md5.getMd5("roombox01589002776omo1197210994oBL"));
    //System.out.println();
    System.out.println(syt);
  }

  private final boolean 爱你 = true; // 爱你是私有属性并且永远是真的


}