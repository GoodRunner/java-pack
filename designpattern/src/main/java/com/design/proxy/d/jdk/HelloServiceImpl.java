package com.design.proxy.d.jdk;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2021-01-16 16:44
 */
public class HelloServiceImpl implements HelleInterface {
  @Override
  public String sayHello(String name) {
    return "hello " + name;
  }
}