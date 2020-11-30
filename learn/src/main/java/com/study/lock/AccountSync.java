package com.study.lock;

/**
 * @description: 加了synchronized的取钱方法
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-09-01 14:34
 */
public class AccountSync implements Account {
  private Integer balance;

  public AccountSync(Integer balance) {
    this.balance = balance;
  }

  @Override
  public Integer query() {
    return this.balance;
  }

  @Override
  public void acquire(Integer i) {
    synchronized (this) {
      this.balance -= i;
    }
  }
}