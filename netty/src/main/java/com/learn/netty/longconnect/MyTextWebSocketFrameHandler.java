package com.learn.netty.longconnect;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import java.time.LocalDateTime;

/**
 * @description: WebSocketFrame 下面有 6个子类  我们这里使用 TextWebSocketFrame
 * TextWebSocketFrame 表示 文本帧
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-11-18 22:40
 */
public class MyTextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
  @Override
  protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
    System.out.println("服务器接收到消息：" + msg.text());
    ctx.channel().writeAndFlush(new TextWebSocketFrame("你好客户端 ，服务器返回消息："+msg.text()));
  }

  @Override
  public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
    System.out.println("handler add long " + ctx.channel().id().asLongText());
    System.out.println("handler add short" + ctx.channel().id().asShortText());
  }

  @Override
  public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
    System.out.println("handler remove long " + ctx.channel().id().asLongText());
    System.out.println("handler remove short" + ctx.channel().id().asShortText());
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    System.out.println(" 发生异常 " + ctx.channel().id().asLongText());
    ctx.channel().close();
  }
}