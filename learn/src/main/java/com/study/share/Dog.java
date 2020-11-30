package com.study.share;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-10-25 11:41
 */
@Slf4j(topic = "dog")
public class Dog {

  //int a;
  short b;

  public static void main(String[] args) {
    Dog dog = new Dog();
    log.error(Integer.toHexString(dog.hashCode()));

    log.info(ClassLayout.parseInstance(dog).toPrintable());
    //log.info(GraphLayout.parseInstance(dog).toPrintable());
    //log.info(GraphLayout.parseInstance(dog).totalSize() + "");

    //log.error(Integer.toHexString(dog.hashCode()));
    //log.info(ClassLayout.parseInstance(dog).toPrintable());

  }

}