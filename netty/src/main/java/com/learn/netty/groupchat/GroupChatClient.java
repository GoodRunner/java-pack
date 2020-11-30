package com.learn.netty.groupchat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import java.util.Scanner;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-11-18 19:58
 */
public class GroupChatClient {


  private String host;
  private Integer port;

  public GroupChatClient(String host, Integer port) {
    this.host = host;
    this.port = port;
  }

  public void run() throws InterruptedException {

    EventLoopGroup group = new NioEventLoopGroup();

    try {
      Bootstrap bootstrap = new Bootstrap();
      bootstrap.group(group)
              .channel(NioSocketChannel.class)
              .handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                  ChannelPipeline pipeline = ch.pipeline();

                  pipeline.addLast("decoder", new StringDecoder());
                  pipeline.addLast("eecoder", new StringEncoder());

                  pipeline.addLast(new GroupChatClientHandler());

                }
              });
      ChannelFuture sync = bootstrap.connect(host, port).sync();
      System.out.println("====准备就绪====");
      Channel channel = sync.channel();
      Scanner scanner = new Scanner(System.in);

      while (scanner.hasNext()) {
        String next = scanner.next();
        // 发送到客户端
        channel.writeAndFlush(next);
      }
    } catch (Exception e) {
      group.shutdownGracefully();
    }
  }

  public static void main(String[] args) throws InterruptedException {
    new GroupChatClient("127.0.0.1", 9999).run();
  }

}