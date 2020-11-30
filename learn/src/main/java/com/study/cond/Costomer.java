package com.study.cond;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-04-30 22:07
 */
public class Costomer extends Thread {
  private XiaoLongBao bao;

  public Costomer(XiaoLongBao bao) {
    this.bao = bao;
  }

  @Override
  public void run() {
    bao.eat();
  }
}