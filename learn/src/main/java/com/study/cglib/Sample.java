package com.study.cglib;

/**
 * @description: cglib sample
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-07-13 16:35
 */
public class Sample implements Cloneable {

  private String name;

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}