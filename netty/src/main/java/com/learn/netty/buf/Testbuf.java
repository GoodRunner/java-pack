package com.learn.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-11-16 23:02
 */
public class Testbuf {
  public static void main(String[] args) {

    ByteBuf buf = Unpooled.buffer(10);

    for (int i = 0; i < 50; i++) {
      buf.writeByte(i);
    }
    System.out.println("capacity :" + buf.capacity());
  }
}