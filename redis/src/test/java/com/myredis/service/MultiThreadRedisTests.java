package com.myredis.service;

//import redis.clients.jedis.Jedis;

public class MultiThreadRedisTests {/*

  public static void main(String[] args) {
    //连接本地的 Redis 服务
    Jedis jedis = new Jedis("localhost");
    //查看服务是否运行
    System.out.println("服务正在运行: " + jedis.ping());

    for (int i = 0; i < 2; i++) {
      int finalI = i;
      new Thread(() -> {
        for (int j = 0; j < 10; j++) {
          jedis.set("a" + finalI, String.valueOf(finalI));
          System.out.println("a" + finalI + " = " + jedis.get("a" + finalI));
        }
      }).start();
    }
  }*/
}
