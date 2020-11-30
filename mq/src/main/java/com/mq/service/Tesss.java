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
      File file = new File("/Users/victor/Desktop/Untitled.csv");
////
////    File file_6548 = new File("/Users/victor/Desktop/6548.csv");
////
      FileInputStream fin = new FileInputStream(file);
////
      BufferedReader brder = new BufferedReader(new InputStreamReader(fin));
////
////    Set<String> set = new HashSet<>();
////
      StringBuilder sb = new StringBuilder("Select code from rb_user where user_name in (");
    while (true) {
      String line = brder.readLine();
      if (line != null && !line.equals("")){
        sb.append("'");
        line = line.replace("\"", "");
        sb.append(line.trim());
        sb.append("',");
      } else {
        break;
      }

    }
    sb.append(")");
    System.out.println(sb.toString());

  }


  public static void djdd() {

    String str = "HZ0720490651\n" +
            "HZ236675\n" +
            "HZ425506\n" +
            "HZ0720791745\n" +
            "HZ440218\n" +
            "HZ256461\n" +
            "HZ233957\n" +
            "HZ310174\n" +
            "HZ0620862717\n" +
            "HZ0720130870\n" +
            "HZ236576\n" +
            "HZ236596\n" +
            "HZ0720203157\n" +
            "HZ0520800141\n" +
            "HZ0620193799\n" +
            "HZ0720524249\n" +
            "HZ427053\n" +
            "HZ0620178358\n" +
            "HZ439761\n" +
            "HZ0720115600\n" +
            "HZ211394\n" +
            "HZ198162\n" +
            "HZ188870\n" +
            "HZ137300\n" +
            "HZ276460\n" +
            "HZ0620153133\n" +
            "HZ0720196131\n" +
            "HZ431578\n" +
            "HZ0720838863\n" +
            "HZ377793\n" +
            "HZ243099\n" +
            "HZ281315\n" +
            "HZ0720740557\n" +
            "HZ0720843666\n" +
            "HZ253372\n" +
            "HZ0520153429\n" +
            "HZ240850\n" +
            "HZ0620619935\n" +
            "HZ348348\n" +
            "HZ0720184316\n" +
            "HZ307165\n" +
            "HZ172657\n" +
            "HZ426784\n" +
            "HZ332218\n" +
            "HZ0720121761\n" +
            "HZ0720202511\n" +
            "HZ0720201430\n" +
            "HZ0920190894\n" +
            "HZ282334\n" +
            "HZ426151\n" +
            "HZ426378\n" +
            "HZ0720545936\n" +
            "HZ0720131372\n" +
            "HZ185206\n" +
            "HZ271153\n" +
            "HZ0720680542\n" +
            "HZ241330\n" +
            "HZ0720147810\n" +
            "HZ252336\n" +
            "HZ270736\n" +
            "HZ252342\n" +
            "HZ415269\n" +
            "HZ0720388249\n" +
            "HZ404963\n" +
            "HZ432740\n" +
            "HZ0720153934\n" +
            "HZ186093\n" +
            "HZ237489\n" +
            "HZ255431\n" +
            "HZ0720343292\n" +
            "HZ440601\n" +
            "HZ0720113010\n" +
            "HZ0720170760\n" +
            "HZ252317\n" +
            "HZ403823\n" +
            "HZ223394\n" +
            "HZ220341\n" +
            "HZ0720127262\n" +
            "HZ0720160572\n" +
            "HZ0620384934\n" +
            "HZ0820177307\n" +
            "HZ0720146868\n" +
            "YHHZ0720159276\n" +
            "YHHZ0420317104\n" +
            "YHHZ0720169526\n" +
            "YHHZ0720522638\n" +
            "YHHZ0520906092\n" +
            "YHHZ0720118652\n" +
            "YHHZ0720106686\n" +
            "YHHZ0720191962\n" +
            "YHHZ0720157147\n" +
            "YHHZ5130\n" +
            "YHHZ0720578313\n" +
            "YHHZ4279\n" +
            "YHHZ0520571455\n" +
            "YHHZ0720175730\n" +
            "YHHZ2857\n" +
            "YHHZ0720754452\n" +
            "YHHZ0720328227\n" +
            "YHHZ0720209853\n" +
            "YHHZ5222\n" +
            "YHHZ5335\n" +
            "YHHZ3224\n" +
            "YHHZ7271\n" +
            "YHHZ0820688120\n" +
            "YHHZ0720129705\n" +
            "YHHZ0520277724\n" +
            "YHHZ0520833818\n" +
            "YHHZ5440\n" +
            "YHHZ0720124390\n" +
            "YHHZ3914\n" +
            "YHHZ0720184316\n" +
            "YHHZ0720638316\n" +
            "YHHZ4477\n" +
            "YHHZ0620410648\n" +
            "YHHZ0720138649\n" +
            "YHHZ4155\n" +
            "YHHZ5441\n" +
            "YHHZ4008\n" +
            "YHHZ5468\n" +
            "YHHZ3778\n" +
            "YHHZ0720975264\n" +
            "YHHZ0720174257\n" +
            "YHHZ0520124706\n" +
            "YHHZ7423\n" +
            "YHHZ0720160316\n" +
            "YHHZ3826\n" +
            "YHHZ0620144866\n" +
            "YHHZ0720147892\n";

    String[] sss = str.split("\n");

    StringBuffer sb = new StringBuffer("select * from rb_user rbu where code in( ");
    System.out.println(sss.length);
    for (String s : sss) {
      String key = sss[0].replace("\"","");
      sb.append("\"");
      sb.append(s);
      sb.append("\"");
      sb.append(",");
    }
    sb.append(")");

    System.out.println(sb.toString());


  }

}