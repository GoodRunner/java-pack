package com.quasar.service;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: test
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2019-05-16 16:05
 */
public class Test {

  public static void main(String[] args)throws Exception {
    Map<String, Object> item = new HashMap<>();

    item.put("name","zhangsan");
    item.put("age","");

    System.out.println(item.get("age").toString());

  }

}