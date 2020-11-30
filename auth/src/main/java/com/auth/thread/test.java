package com.auth.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-04-24 10:55
 */
public class test {

  public static void main(String[] args) {

    // 这个包子
    BaoZi baozi = new BaoZi();
    // 这个客人
    Customer cus = new Customer(baozi);
    // 这个服务员
    Waiter wai = new Waiter(baozi);

    //new FutureTask(wai);

    cus.start();

    wai.start();

    ThreadLocal<String> threadLocal = new ThreadLocal<>();

    threadLocal.set("This is a slogan!");

    threadLocal.get();

  }

}