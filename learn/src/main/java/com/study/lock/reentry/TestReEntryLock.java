package com.study.lock.reentry;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-10-30 14:38
 */
public class TestReEntryLock {

  public static void main(String[] args) {
    ReentrantLock reentrantLock = new ReentrantLock();

    reentrantLock.lock();

  }


}