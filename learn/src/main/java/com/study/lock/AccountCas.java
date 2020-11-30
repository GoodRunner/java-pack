package com.study.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: 使用了cas的取钱方法
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-09-01 14:37
 */
public class AccountCas implements Account {

  private AtomicInteger balance;

  public AccountCas(int balance) {
    this.balance = new AtomicInteger(balance);
  }

  @Override
  public Integer query() {
    return this.balance.get();
  }

  @Override
  public void acquire(Integer i) {
    while (true) {
      // 之前的钱数
      int pre = balance.get();
      int next = pre - i;
      if (balance.compareAndSet(pre, next)) {
        break;
      }
    }
  }
}