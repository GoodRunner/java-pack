package com.learn.netty.javabio;

import lombok.extern.slf4j.Slf4j;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-10-31 23:56
 */
@Slf4j(topic = "EchoClient")
public class EchoClient {

  public static void main(String[] args) throws IOException {

    Socket socket = new Socket();

    socket.connect(new InetSocketAddress("127.0.0.1", 10001));
    log.info("客户端启动 。。。");
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
    out.print("1\n");
    out.flush();
    System.out.println(" client send ");
    System.out.println(" client received : " + in.readLine());

    socket.close();
  }

}