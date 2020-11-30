package com.learn.netty.groupchat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @description: 群聊案例
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-11-17 22:12
 */
public class GroupChatServer {

  private int port;

  public GroupChatServer(int port){
    this.port = port;
  }


  public void run() throws Exception {
    EventLoopGroup boos = new NioEventLoopGroup(1);
    EventLoopGroup worker = new NioEventLoopGroup(1);

    ServerBootstrap bootstrap = new ServerBootstrap();
    try {
      bootstrap.group(boos, worker)
              .channel(NioServerSocketChannel.class)
              .option(ChannelOption.SO_BACKLOG, 128)
              .childOption(ChannelOption.SO_KEEPALIVE, true)
              .childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                  // 获取 pipleline
                  ChannelPipeline pipeline = ch.pipeline();

                  pipeline.addLast("decoder", new StringDecoder());
                  pipeline.addLast("eecoder", new StringEncoder());
                  // 自己的handler
                  pipeline.addLast(new GroupChatServerHandler());
                }
              });
      System.out.println("服务器已经启动");

      ChannelFuture future = bootstrap.bind(port).sync();
      future.channel().closeFuture().sync();
    }catch (Exception e) {
      boos.shutdownGracefully();
      worker.shutdownGracefully();
    }

  }

  public static void main(String[] args) throws Exception {
    GroupChatServer groupChatServer = new GroupChatServer(9999);
    groupChatServer.run();
  }

}