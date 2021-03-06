package com.mybatis.util;

import cn.hutool.http.HttpUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
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
import java.util.stream.Collectors;
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

    String syt = api.sign("/jiaowu-ps/api/v1/classes/list?school_id=65&fields=class_code,class_type_code,class_type_name,management_dept_code,management_dept_name,project_code, project_name, school_id,class_teachers,grade_code,grade_name,area_name,teaching_method,class_begin_date,class_end_date,class_name,teaching_channel&class_codes=CESHI502776&page_no=1&page_size=20");
    System.out.println(syt);
  }

  private final boolean 爱你 = true; // 爱你是私有属性并且永远是真的


  public static void getPPT() throws Exception {



    HashMap<String, Object> objectObjectHashMap = new HashMap<>();

    objectObjectHashMap.put("Sec-Fetch-Dest", "document");

    byte[] bts = new byte[1024];

    for (int i = 1; i <=59 ; i++) {
      String url = "https://docimg1.docin.com/docinpic.jsp?file=2271006620&width=1000&sid=yHH6pIOVGJZp3GVfrprls8d*XW3T2GpHKgthzc65KBZ58yF8yA74Un9mfrHxffcH&pcimg=1&pageno=";
      File f = new File("/Users/victor/Desktop/ppt/" + i + ".jpg");
      url = url + i;
      URL s = new URL(url);

      InputStream fs = s.openStream();

      //String result = HttpUtil.get(url, objectObjectHashMap);
      FileOutputStream fileOutputStream = new FileOutputStream(f);
      while (fs.read(bts) > 0) {
        fileOutputStream.write(bts);
      }
      fileOutputStream.flush();
      fs.close();
      fileOutputStream.close();
    }

    Thread.sleep(30000);

  }

}