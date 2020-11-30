package com.auth.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @description: 计算给出的数组中的数字的总和, 使用 forkjoin思想来解决.
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-04-25 11:43
 */
public class SumTask extends RecursiveTask<Integer> {

  // 每个最小工作单元的大小
  private static final int THRESHOLD = 2;

  private int[] items;

  public void SumTask(int[] items) {
    this.items = items;
  }

  @Override
  protected Integer compute() {

    int sum = 0;



    return null;
  }
}