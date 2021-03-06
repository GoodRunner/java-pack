package com.design.proxy.d.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2021-01-16 16:46
 */
public class MyHelloHandler implements InvocationHandler {

  // 目标对象
  private Object target;

  public MyHelloHandler(Object target){
    this.target = target;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

    System.out.println(" 说之前清清嗓子 ");

    Object invoke = method.invoke(target, args);
    System.out.println(invoke);
    System.out.println(" 说之后挥挥手 ");

    return invoke;
  }
}