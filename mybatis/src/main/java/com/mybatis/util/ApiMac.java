package com.mybatis.util;

import java.util.HashSet;
import java.util.Set;
import javax.crypto.Mac;

import javax.crypto.spec.SecretKeySpec;

//import org.apache.commons.codec.binary.Base64;
import org.apache.tomcat.util.codec.binary.Base64;

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

  static final int hash(String key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
  }


  static char[] chars = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s'
          ,'t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q',
          'R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};


  static String get666() {

    StringBuffer verble = new StringBuffer();

    int rom = (int)(Math.random() * 900 + 100);
    verble.append(rom);
    verble.append(System.nanoTime());

    String subfix = String.valueOf(Math.abs(hash(verble.toString())));

    StringBuffer result = new StringBuffer("omo");
    int length = subfix.length();
    if(length > 13) {
      result.append(subfix.substring(0,12));
    }else  if (length < 13) {
      result.append(subfix);
      int temp = 13 - length;

      for (int i = 1; i <= temp ; i++) {
        char str = chars[(int)(Math.random() * 62)];
        result.append(str);
      }
    }
    return result.toString();
  }

  public static void main(String[] args) {

    ApiMac api = new ApiMac("59a0e77c3ec04e8db70c4402ef0e9f47");

    String syt = api.sign("/jiaowu-ps/api/v1/classes/list?school_id=5&fields=class_code,class_type_code,class_type_name,management_dept_code,management_dept_name,project_code, project_name, school_id&teaching_method=14&class_state=0&page_no=2&page_size=20");
    System.out.println(syt);
    //Set set = new HashSet();

//    for (int i = 0; i <100000 ; i++) {
//      String str = get666();
//      System.out.println(str);
//      //set.add(str);
//    }

    //System.out.println(set.size());

  }

}