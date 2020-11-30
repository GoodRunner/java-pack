package com.learn.netty.heartbeat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-11-18 20:22
 */
public class MyServer {

  public static void main(String[] args) {

    EventLoopGroup boos = new NioEventLoopGroup(1);
    EventLoopGroup worker = new NioEventLoopGroup();

    ServerBootstrap bootstrap = new ServerBootstrap();
    try {
      bootstrap.group(boos, worker)
              .channel(NioServerSocketChannel.class)
              .handler(new LoggingHandler(LogLevel.INFO))
              //.option(ChannelOption.SO_BACKLOG, 128)
              //.childOption(ChannelOption.SO_KEEPALIVE, true)
              .childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                  // 获取 pipleline
                  ChannelPipeline pipeline = ch.pipeline();
                  /**
                   * IdleStateHandler 是 netty提供的处理空闲状态的处理器
                   * readerIdleTime   是 表示多长时间没有读，
                   * writerIdleTime   表示多长时间没有写了
                   * allIdleTime    表示 多长时间  没有读和没有写
                   *
                   *
                   * 会触发 IdleStateEvent
                   *
                   * 触发 IdleStateEvent  后 会传递给 管道中的下一个handler去处理
                   */
                  pipeline.addLast(new IdleStateHandler(3, 5, 7, TimeUnit.SECONDS));
                  // 自己处理的handler
                  pipeline.addLast(new MyServerHandler());
                }
              });

      ChannelFuture sync = bootstrap.bind(9999).sync();

      sync.channel().closeFuture().sync();

    }catch (Exception e) {
      boos.shutdownGracefully();
      worker.shutdownGracefully();
    }
  }

}