package com.learn.netty.longconnect;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-11-18 20:51
 */
public class MyServer {

  public static void main(String[] args)throws Exception {


    EventLoopGroup boos = new NioEventLoopGroup(1);
    EventLoopGroup worker = new NioEventLoopGroup();

    ServerBootstrap bootstrap = new ServerBootstrap();
    try {
      bootstrap.group(boos, worker)
              .channel(NioServerSocketChannel.class)
              .handler(new LoggingHandler(LogLevel.INFO))
              //.option(ChannelOption.SO_BACKLOG, 128)
              .childOption(ChannelOption.SO_KEEPALIVE, true)
              .childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                  // 获取 pipleline
                  ChannelPipeline pipeline = ch.pipeline();
                  // 因为是 基于 http协议 所以添加http的编码解码器
                  pipeline.addLast(new HttpServerCodec());
                  // 是已 块的方式写 添加 ChunkedWriteHandler 处理器
                  pipeline.addLast(new ChunkedWriteHandler());
                  /**
                   * http数据在传输过程中是分段的， HttpObjectAggregator 可以将多个段进行聚合
                   *
                   */
                  pipeline.addLast(new HttpObjectAggregator(8192));

                  /**
                   * 对应 websocket 他的数据是 frame（帧） 进行传递
                   *
                   * 浏览器请求时 ws://localhost:7000/xxx
                   *
                   * WebSocketServerProtocolHandler 的核心功能是将 http协议 升级为 websocket 协议 保持长链接
                   *
                   */
                  pipeline.addLast(new WebSocketServerProtocolHandler("/hello"));

                  // 添加自己的处理 handler
                  pipeline.addLast(new MyTextWebSocketFrameHandler());

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