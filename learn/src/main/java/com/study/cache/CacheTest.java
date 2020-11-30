package com.study.cache;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-07-16 22:14
 */
public class CacheTest {

  public static void main(String[] args) throws IOException {

    String paramCourse = "";
    String course = "1,2,3";

    Set<String> paramSet = new HashSet<>();
    Set<String> dbSet = new HashSet<>();
    Set<String> newSet = new HashSet<>();
    if ("" != paramCourse) {
      // 传输 过来的课件
      paramSet.addAll(Arrays.asList(paramCourse.split(",")));
    }
    if ("" != course) {
      // 数据库中的课件
      dbSet.addAll(Arrays.asList(course.split(",")));
    }
    // 得出需要新增的 课件 ID    paramSet
    paramSet.removeAll(dbSet);

    // 得出需要删除的 课件 ID    dbSet
    dbSet.removeAll(paramSet);

    System.out.println("123445");

  }



}