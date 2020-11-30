package com.study.lock;

/**
 * @description: 普通取钱方法， 有数据问题
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-09-01 14:23
 */
public class AccountNormal implements Account {

  private Integer balance;

  public AccountNormal(Integer balance) {
    this.balance = balance;
  }

  @Override
  public Integer query() {
    return this.balance;
  }

  @Override
  public void acquire(Integer i) {
    this.balance -= i;
  }
}