package com.mq.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2019-11-07 17:09
 */
public class Tesss {


  public static void main(String[] args)throws Exception {

    File file = new File("/Users/victor/Downloads/school.csv");

    FileInputStream fin = new FileInputStream(file);

    BufferedReader brder = new BufferedReader(new InputStreamReader(fin));

    StringBuffer sql = new StringBuffer("INSERT INTO `hl_school` (`create_time`, `is_deleted`, `update_time`, `school_id`, `school_name`, `school_order`,`is_virtual`) \n VALUES  ");

    while (true) {
      String line = brder.readLine();
      if (line != null){
        String[] sz = line.split(",");

        if (sz.length < 2) {
          System.out.println(sz[0]);
        }

        //sz[0]  学校id
        //sz[1]  学校名称
        sql.append(", \n");
        // INSERT INTO `hl_school` (`id`, `create_time`, `is_deleted`, `update_time`, `school_id`, `school_name`, `school_order`)
        //VALUES
        sql.append("('2019-11-07 10:57:26', 1, '2019-11-07 10:57:26', ");
        sql.append(sz[0]);
        sql.append(",'");
        sql.append(sz[1]);

        sql.append("', 1,0)");

      } else {
        break;
      }

    }
    fin.close();

    System.out.println(sql.toString());

  }

}