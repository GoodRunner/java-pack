package com.study.threadpool;

import java.math.BigDecimal;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description:
 * @author: victor
 * 对象分配
 * -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails
 */
public class TestLambda {

  public void say(Human m){
    System.out.println("Guy!");
  }
  public void say(Man m){
    System.out.println("man!");
  }
  public void say(Woman m){
    System.out.println("Girl!");
  }

  public static void main(String[] args) {

    //Human man = new Man();
    //Human woman = new Woman();

    //TestLambda m = new TestLambda();

    //m.say(man);
    //m.say(woman);

    System.out.println(Human.str);

  }

}