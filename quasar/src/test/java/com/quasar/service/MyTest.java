package com.quasar.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description: test
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2019-05-16 15:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

  @Test
  public void doTest() {

    TestA aaa = new TestA("aaa");
    aaa.sleep();
    aaa.awake();

    TestA AAA = new TestA("AAA");
    AAA.sleep();
    AAA.awake();

  }

}