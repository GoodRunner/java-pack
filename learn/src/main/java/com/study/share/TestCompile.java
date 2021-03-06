package com.study.share;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.openjdk.jol.info.ClassLayout;
import org.springframework.util.StringUtils;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-10-25 11:53
 */
public class TestCompile {



  public static void main(String[] args) {

    try {
      String date = getDate("2021-02-01 12:30:25");

      String dateAddOne = getDateAddOne(date);

      System.out.println(dateAddOne);

    } catch (ParseException e) {
      e.printStackTrace();
    }

  }

  public static String getDate(String dateStr) throws ParseException {
    String dateStrNew = "";
    try {
      if (dateStr.contains(":")) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfTarget = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(dateStr);
        dateStrNew = sdfTarget.format(date);
      }
    } catch (Exception e) {
    }
    return dateStrNew;
  }

  public static String getDateAddOne(String dateOne) {
    String format = "";
    if(StringUtils.isEmpty(dateOne)){
      return format;
    }
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {

      Date dd = df.parse(dateOne);

      Calendar calendar = Calendar.getInstance();

      calendar.setTime(dd);

      calendar.add(Calendar.DAY_OF_MONTH, 1);//加一天
      format = df.format(calendar.getTime());

    } catch (ParseException e) {
     //log.error("error", e);
    }
    return format;
  }

}