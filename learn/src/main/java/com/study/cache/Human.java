package com.study.cache;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-08-02 20:35
 */
public class Human {

  static {
    System.out.println("Human init !");
  }

  static String hello = "hello";

  static final String world = "world";

  static String value = hello;

  private String name;

  private int age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Human{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
  }
}