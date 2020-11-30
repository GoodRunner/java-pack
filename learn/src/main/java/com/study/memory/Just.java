package com.study.memory;

import com.google.common.base.Splitter;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import org.springframework.util.StringUtils;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-05-22 10:46
 * java -XX:+PrintFlagsFinal -version    // 显示jvm虚拟机参数   其中 [manageable] 的是可动态的修改的
 */
public class Just {

  public static void main(String[] args)throws Exception {

    List<String> list = new ArrayList<>();
    list.add("rg");
    list.add("eg");
    list.add("yg");

    System.out.println(multyNum(getFunc(), list, 9));

    //useMyConsumer(createConsumer(), "hello world!");

    //usePredicate(createPredicate(), "wupeiqun");

    Splitter.on(",").split("ashfj,asda,egre,erg,erg");

    System.out.println(Optional.ofNullable("sss").orElse(""));

  }

  /**
   * 定义一个Function 有入参 有出参
   * @return
   */
  private static Function<List<String>, Integer> getFunc() {

    Function<List<String>, Integer> func = new Function<List<String>, Integer>() {
      @Override
      public Integer apply(List<String> strings) {
        return strings.size();
      }
    };
    return func;
  }


  /**
   * 使用 一个 Function
   * @param func
   * @param strs
   * @param num
   * @return
   */
  private static int multyNum (Function<List<String>, Integer> func, List<String> strs, int num) {
    return func.apply(strs) * num;
  }

  /**
   * 返回 一个 Consumer 有入参无出参
   * @return
   */
  private static Consumer<String> createConsumer() {
    return mystr -> {
      System.out.println(mystr);
    };
  }

  /**
   * 使用一个 Consumer
   * @param consumer
   * @param hello
   */
  private static void useMyConsumer (Consumer<String> consumer, String hello) {
    consumer.accept(hello);
  }


  /**
   * 创建一个 Predicate 有入参 出参是 Boolean 类型
   * @return
   */
  private static Predicate<String> createPredicate() {
    return str -> {
      return str.equals("wupeiqun");
    };
  }

  /**
   * 使用一个 Predicate
   * @param pre
   * @param name
   */
  private static void usePredicate(Predicate<String> pre, String name) {
    System.out.println(pre.test(name));
  }


}