package com.auth.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-03-26 16:27
 */
public class Test {
  public static void main(String[] args)throws Exception {
    String path = "/Users/victor/Desktop/addStuPhone.csv";

    File file = new File(path);

    FileReader fin = new FileReader(file);

    BufferedReader reader = new BufferedReader(fin);

    Set<String> set = new HashSet<>();

    Map<String,String> map = new HashMap<>();

    // StringBuffer ssb = new StringBuffer();

    while (reader.read() != -1) {
      String line = reader.readLine();
      String sz[] = line.split(",");

      StringBuffer ssb = new StringBuffer();

      ssb.append("update hl_student set mobile = '' where mobile = '");

      ssb.append(sz[0]);
      ssb.append("';");
      System.out.println(ssb.toString());
    }

  }
}