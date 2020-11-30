package com.study.lock.mylock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @description: 自己实现的锁
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-05-03 07:59
 */
public class SelfLock implements Lock {
  @Override
  public void lock() {

  }

  @Override
  public void lockInterruptibly() throws InterruptedException {

  }

  @Override
  public boolean tryLock() {
    return false;
  }

  @Override
  public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
    return false;
  }

  @Override
  public void unlock() {

  }

  @Override
  public Condition newCondition() {
    return null;
  }

  static class MySync extends AbstractQueuedLongSynchronizer {

    @Override
    protected boolean tryAcquire(long arg) {
      return super.tryAcquire(arg);
    }

    @Override
    protected boolean tryRelease(long arg) {
      return super.tryRelease(arg);
    }

    @Override
    protected long tryAcquireShared(long arg) {
      return super.tryAcquireShared(arg);
    }

    @Override
    protected boolean tryReleaseShared(long arg) {
      return super.tryReleaseShared(arg);
    }

    @Override
    protected boolean isHeldExclusively() {
      return super.isHeldExclusively();
    }
  }

}