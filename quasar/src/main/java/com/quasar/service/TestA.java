package com.quasar.service;

/**
 * @description: A 检验对象锁
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2019-05-16 14:51
 */
public class TestA {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TestA(String name) {
    this.name = name;
  }

  public synchronized void sleep() {
    System.out.println(this.getName() + " need sleep");
    try {
      Thread.sleep(6000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(this.getName() + " sleep done");
  }

  public synchronized void awake() {

    System.out.println("oh now " + this.getName() + " is awake!!");

  }

}