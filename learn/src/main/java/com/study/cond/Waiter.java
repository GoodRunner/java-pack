package com.study.cond;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-04-30 22:06
 */
public class Waiter extends Thread {
  private XiaoLongBao bao;

  public Waiter(XiaoLongBao bao) {
    this.bao = bao;
  }

  @Override
  public void run() {
    bao.steam();
  }
}