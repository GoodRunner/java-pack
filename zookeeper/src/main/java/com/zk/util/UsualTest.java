package com.zk.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @description: test
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2019-12-17 14:09
 */
public class UsualTest {

  public static void main(String[] args) {



    // 1万个元素
    List<Integer> list = new ArrayList<>(10000);

    Random random = new Random(4999);
    // 创建原始数据
    for (int i = 0; i < 100; i++) {
      list.add(random.nextInt(101));
    }

    list.stream().limit(5).sorted().forEach(System.err::println);

    long a = System.currentTimeMillis();

    long  count = list.stream().filter(e -> e>8999).count();

    long b = System.currentTimeMillis();

    System.out.println("使用stream，耗时："+(b-a)+"  最后结果:"+count);

    int myCount = 0;


    long c = System.currentTimeMillis();

    for (Integer itg : list) {
      if (itg.intValue() > 8999) {
        myCount = myCount + 1;
      }
    }
    long d = System.currentTimeMillis();

    System.out.println("不用stream，耗时："+(d-c)+"  最后结果:"+myCount);




    //
    //System.out.println(list);

  }

}