package com.learn.netty.javanio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-11-01 10:04
 */

/**
 * nio 的三个核心
 *
 * Channel
 *
 * Buffer
 *
 * Selector
 *
 */
public class testnioBlocking {

  // 客户端
  // nio 阻塞模式 简单实现 传图片
  @Test
  public void client() throws IOException {
    // 获取通道
    SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 10090));
    // 分配buffer 指定大小
    ByteBuffer buffer = ByteBuffer.allocate(1024);
    //
    FileChannel infilechannel = FileChannel.open(Paths.get("/Users/victor/Desktop/linus.png"), StandardOpenOption.READ);
    // 循环读 并发送
    while (infilechannel.read(buffer) != -1) {
      buffer.flip();
      socketChannel.write(buffer);
      buffer.clear();
    }
    infilechannel.close();
    socketChannel.close();
  }

  // 服务端
  @Test
  public void server() throws IOException {

    // 获取通道
    ServerSocketChannel sSocketChannel = ServerSocketChannel.open();
    //绑定端口号
    sSocketChannel.bind(new InetSocketAddress(10090));

    FileChannel outChannel = FileChannel.open(Paths.get("/Users/victor/Desktop/iAmCopy.png"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

    // 获取客户端链接的通道
    SocketChannel sChannel = sSocketChannel.accept();

    ByteBuffer buffer = ByteBuffer.allocate(1024);

    while (sChannel.read(buffer) != -1) {
      buffer.flip();
      outChannel.write(buffer);
      buffer.clear();
    }
    sChannel.close();
    outChannel.close();
    sSocketChannel.close();
  }

}