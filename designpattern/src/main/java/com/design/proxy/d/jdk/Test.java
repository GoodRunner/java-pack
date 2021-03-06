package com.design.proxy.d.jdk;

import java.lang.reflect.Proxy;
import java.util.Date;
import java.util.TreeSet;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2021-01-16 16:51
 */
public class Test {

  public static void main(String[] args) {

//    // 创建目标对象
//    HelleInterface helloService = new HelloServiceImpl();
//
//    // 创建 Handler
//    MyHelloHandler myHelloHandler = new MyHelloHandler(helloService);
//
//    HelleInterface proxy = (HelleInterface)Proxy.newProxyInstance(helloService.getClass().getClassLoader(),
//            helloService.getClass().getInterfaces(), myHelloHandler);
//    proxy.sayHello("大王八");

    TreeSet<Date> ts = new TreeSet<>();
    ts.add(new Date(1623297534L));
    //ts.add(new Date(1610251134L));
    //ts.add(new Date());
    //ts.add(new Date(1618027134L));

    System.out.println(ts);

  }

}