package com.learn.netty.javabio;

import lombok.extern.slf4j.Slf4j;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-10-31 23:47
 */
@Slf4j(topic = "echoserver")
public class EchoServer {

  public static void main(String[] args) throws IOException {

    ServerSocket serverSocket = new ServerSocket();

    serverSocket.bind(new InetSocketAddress("127.0.0.1",10001));

    log.info("server started ...port: 10001");

    while (true) {
      new Thread(new MyTask(serverSocket.accept())).start();
    }

  }

  private static class MyTask implements Runnable {

    private Socket socket;

    public MyTask(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {
      try {
        byte[] bts = new byte[1024];
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        StringBuffer sb = new StringBuffer();
        //inputStream.read(bts);
        for (;;) {
          int n = inputStream.read(bts); // 反复调用read()方法，直到返回-1
          if (n == -1) {
            break;
          }
          String msg = new String(bts);
          sb.append(msg);
        }
        String body = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        while ((body = in.readLine()) != null && body.length()!=0) {
          System.out.println("server received : " + body);
          out.print("2\n");
          out.flush();
        }

      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        try {
          socket.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

}