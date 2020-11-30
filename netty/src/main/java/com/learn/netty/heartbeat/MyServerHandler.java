package com.learn.netty.heartbeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-11-18 20:35
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {

  /**
   * 当有用户的时间触发
   * @param ctx 上下文
   * @param evt 事件
   * @throws Exception
   */
  @Override
  public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
    if (evt instanceof IdleStateEvent) {
      IdleStateEvent event = (IdleStateEvent) evt;

      String evt_type = null;

      switch (event.state()) {
        case READER_IDLE:
          evt_type = "读空闲";break;
        case WRITER_IDLE:
          evt_type = "写空闲";break;
        case ALL_IDLE:
          evt_type = "全空闲";break;
      }
      System.out.println(ctx.channel().remoteAddress() + " ----发生----> " + evt_type);
      System.out.println("服务端相应处理。。。");
    }
  }
}