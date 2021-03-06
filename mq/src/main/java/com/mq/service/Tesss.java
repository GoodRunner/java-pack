package com.mq.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2019-11-07 17:09
 */
public class Tesss {


  public static void main(String[] args)throws Exception {

    // 获取文件
      File file = new File("/Users/victor/Desktop/roomId.csv");

      FileInputStream fin = new FileInputStream(file);

      BufferedReader brder = new BufferedReader(new InputStreamReader(fin));

      Set<String> set = new HashSet<>();

    StringBuilder sb = new StringBuilder("update rb_classroom set is_deleted = b'1'  where classroom_id in (");
    while (true) {
      String line = brder.readLine();

      if (line != null && !line.equals("")){
        String[] sz = line.split(",");
        //sb.append("'");
        sb.append(sz[0]);
        //sb.append("'");
        sb.append(", ");

      } else {
        break;
      }
    }
    sb.append(")");

    System.out.println(sb.toString());
  }

}