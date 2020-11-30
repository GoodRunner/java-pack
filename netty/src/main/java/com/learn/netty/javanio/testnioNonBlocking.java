package com.learn.netty.javanio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-11-04 21:29
 */

/**
 * nio简单实现聊天室
 */
public class testnioNonBlocking {

  /**
   * 客户端
   * @throws IOException
   */
  @Test
  public void client() throws IOException {
    SocketChannel schannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 10002));

    schannel.configureBlocking(false);

    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      String str = scanner.next();
      byteBuffer.put(("客户端消息: " + str).getBytes());

      byteBuffer.flip();

      schannel.write(byteBuffer);

      byteBuffer.clear();
    }

    schannel.close();
  }

  /**
   * 服务端
   */
  @Test
  public void server() throws IOException {
    ServerSocketChannel ssChannel =  ServerSocketChannel.open();

    ssChannel.bind(new InetSocketAddress(10002));

    ssChannel.configureBlocking(false);

    Selector selector = Selector.open();

    ssChannel.register(selector, SelectionKey.OP_ACCEPT);

    // 循环检查 selector上是否有 就绪的 key
    while (selector.select() > 0) {
      Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

      while (iterator.hasNext()) {
        SelectionKey key = iterator.next();

        if (key.isAcceptable()) {
          SocketChannel schannel = ssChannel.accept();
          schannel.configureBlocking(false);
          schannel.register(selector, SelectionKey.OP_READ);
        } else if (key.isReadable()) {

          SocketChannel schannel = (SocketChannel)key.channel();

          ByteBuffer buffer = ByteBuffer.allocate(1024);

          int lenth = 0;

          while ((lenth = schannel.read(buffer)) != -1) {
            String str = new String(buffer.array(),0, lenth);

            System.out.println(str);
            buffer.clear();
          }
        }

      }
      iterator.remove();
    }

  }

}