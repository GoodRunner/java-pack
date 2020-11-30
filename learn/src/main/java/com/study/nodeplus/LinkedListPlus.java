package com.study.nodeplus;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-05-21 17:33
 */
public class LinkedListPlus {

  public static void main(String[] args) {
    int[] sz = {1,0,0,2,1,0,1,3,2,1,2,1};
    //int[] sz = {1,5,0,0,3};
    System.out.println(getWaterSize(sz));
  }

  public static int getWaterSize(int[] array) {
    int waterSize = 0;
    int maxNum = 1;
    int max = array[0];
    int maxStartIndex = 0;
    int maxEndIndex = 0;
    for (int index = 0; index < array.length; index++ ) {
      int a = array[index];
      if (a > max) {
        max = a;
        maxNum = 1;
        maxStartIndex = index;
        maxEndIndex = index;
      } else if (a == max) {
        maxNum++;
        maxEndIndex = index;
      }
    }
    if (maxNum > 1) {
      int sum = 0;
      for (int index = maxStartIndex;index < maxEndIndex;index++ ){
        sum += array[index];
      }
      waterSize = max * (maxEndIndex - maxStartIndex+1) - sum;
    }
    if (maxStartIndex > 0) {
      int left = array[0];
      for (int index = 1;index < maxStartIndex;index++ ) {
        int now = array[index];
        if (now < left) {
          waterSize+= left - now;
        }else{
          left = now;
        }
      }
    }
    if (maxEndIndex < array.length-1) {
      int right = array[ array.length-1];
      for (int index = array.length-1;index > maxEndIndex; index--  ) {
        int now = array[index];
        if (now < right) {
          waterSize+= right - now;
        }else{
          right = now;
        }
      }
    }
    return waterSize;
  }


}