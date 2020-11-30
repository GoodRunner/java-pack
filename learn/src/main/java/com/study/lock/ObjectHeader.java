package com.study.lock;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-10-16 14:17
 */
@Slf4j
public class ObjectHeader {

  public static void main(String[] args) {



    L l = new L();

    //System.out.println(Integer.toHexString(l.hashCode()));
    //System.out.println("还未启动  ---  无锁");
//    log.error(ClassLayout.parseInstance(l).toPrintable());
//    synchronized (l) {
//      log.error(ClassLayout.parseInstance(l).toPrintable());
//    }
//    log.error(ClassLayout.parseInstance(l).toPrintable());

    log.error(ClassLayout.parseInstance(l).headerSize() + "");


  }

}