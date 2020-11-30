package com.study.memory;

import java.util.Objects;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-05-24 17:37
 */
public class Student {

  private Integer id;

  private String name;

  private Integer money;

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setMoney(Integer money) {
    this.money = money;
  }

  public Integer getMoney() {
    return money;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return Objects.equals(id, student.id) &&
            Objects.equals(name, student.name);
  }


}