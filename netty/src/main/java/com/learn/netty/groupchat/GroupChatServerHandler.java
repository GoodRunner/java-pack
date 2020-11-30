package com.learn.netty.groupchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-11-18 19:39
 */
public class GroupChatServerHandler extends SimpleChannelInboundHandler<String> {


  // 定义 channel组 管理所有 channel
  private static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);


  /**
   * 接收消息  处理转发
   * @param ctx
   * @param msg
   * @throws Exception
   */
  @Override
  protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
    Channel channel = ctx.channel();

    System.out.println("客户端【"+channel.remoteAddress()+"】 msg:" + msg);

    for (Channel ch : group) {
      if (ch == channel) {
        // 是自己
        ch.writeAndFlush("消息【" + msg + "】发送成功");
      } else {
        //是别人
        ch.writeAndFlush("客户端【"+ channel.remoteAddress() +"】发来消息： " + msg);
      }
    }

  }

  /**
   * 表示链接建立
   * @param ctx
   * @throws Exception
   */
  @Override
  public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

    group.writeAndFlush("客户端 【" + ctx.channel().remoteAddress() + "】 上线了");

    group.add(ctx.channel());
  }

  /**
   * 通道激活
   * @param ctx
   * @throws Exception
   */
  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {

  }

  /**
   *
   * @param ctx
   * @throws Exception
   */
  @Override
  public void channelInactive(ChannelHandlerContext ctx) throws Exception {

  }

  @Override
  public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
    group.writeAndFlush("客户端 【" + ctx.channel().remoteAddress() + "】 离线了");
    group.remove(ctx.channel());
  }
}