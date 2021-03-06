package com.myredis.Util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description:  linkedHashMap 实现 lru cache
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-12-11 14:41
 */
public class LruCache<T> extends LinkedHashMap<T, Object> {

  private Integer maxSize;

  /**
   * 构造方法
   * @param maxSize 混存最大个数
   */
  public LruCache(int maxSize) {
    super(maxSize, 0.75f, true);
    this.maxSize = maxSize;
  }

  public Object put(T key) {
    return super.put(key, key);
  }

  @Override
  protected boolean removeEldestEntry(Map.Entry<T, Object> eldest) {
    return size() > maxSize;
  }

  public static void main(String[] args) {

    LruCache<String> lruCache = new LruCache(4);

    lruCache.put("1");
    lruCache.put("2");
    lruCache.put("3");
    lruCache.put("4");

    lruCache.get("1");

    lruCache.put("5");

    System.out.println(lruCache);

  }

}