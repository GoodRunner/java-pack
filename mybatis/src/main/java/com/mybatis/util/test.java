package com.mybatis.util;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-04-18 03:06
 */
public class test {

  static String TEACHEING_CHANNL_YDB = "1038";
  static String TEACHEING_CHANNL_YXB = "1037";
  static String TEACHEING_CHANNL_BILIN = "1036";
  static String TEACHEING_CHANNL_VIP = "1375";
  //  String TEACHEING_CHANNL_DOUBLE = "1039";
  static String TEACHEING_CHANNL_JIAOWU_DT = "1374";

  private static Map<Integer,String> teachingChannelMap;
  static {
    teachingChannelMap = new HashMap<>();
    teachingChannelMap.put(1,TEACHEING_CHANNL_YXB);
    teachingChannelMap.put(2,TEACHEING_CHANNL_JIAOWU_DT);
    teachingChannelMap.put(3,TEACHEING_CHANNL_YDB);
    teachingChannelMap.put(4,TEACHEING_CHANNL_VIP);
    teachingChannelMap.put(1,TEACHEING_CHANNL_BILIN);
  }

  public static void main(String[] args) {
   Integer s =  getTeachingChannelMapKey("1037");
    System.out.println(s);
  }

  private static Integer getTeachingChannelMapKey(String value){
    Iterator<Map.Entry<Integer, String>> entries = teachingChannelMap.entrySet().iterator();
    while (entries.hasNext()) {
      Map.Entry<Integer, String> entry = entries.next();
      if(entry.getValue().equals(value)){
        return entry.getKey();
      }
    }
    //返回一个默认的值
    return 2;
  }

  static void work(int x) {
    x = 11;
  }

  static void ouput(Map<String, Object> map) {
    map.put("name", "霍金");
  }

}