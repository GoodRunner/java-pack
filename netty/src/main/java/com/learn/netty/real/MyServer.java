package com.learn.netty.real;

import io.netty.channel.ChannelFuture;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-11-07 09:39
 */
public class MyServer {

  public static void main(String[] args) {
    List<Long> list = new ArrayList<>();

    list.add(1L);
    list.add(2L);
    list.add(3L);

    List<Long> list2 = new ArrayList<>();


    list2.add(2L);
    list2.add(3L);
    list2.add(4L);

    List<Long> list3 = new ArrayList<>(list);

    // list3表示需要删除的东西
    list3.removeAll(list2);

    // list2表示需要增加的东西
    list2.removeAll(list);


    System.out.println(list3);

  }

}