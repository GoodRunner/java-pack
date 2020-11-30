package com.study.cond;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-04-30 22:10
 */
public class test {

  public static void main(String[] args) {

    ReentrantLock l = new ReentrantLock();

    l.newCondition();

    XiaoLongBao bao = new XiaoLongBao();

    Costomer c = new Costomer(bao);

    Waiter w = new Waiter(bao);

    c.start();

    w.start();

  }

}