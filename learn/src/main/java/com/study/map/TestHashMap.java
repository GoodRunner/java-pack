package com.study.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.LongAdder;

/**
 * @description: c
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-05-05 20:28
 */
public class TestHashMap {

  volatile String s = "";

  public static void main(String[] args) {

    HashMap<String,String> map = new HashMap(64);
    map.put("llmcvmv","ggokro");
    ConcurrentHashMap<String, String> cchm = new ConcurrentHashMap();
    cchm.put("sdfsdf", "rvrgtb");
    cchm.size();

  }

  final static char CH_1 = '(', CH_2 = ')';
  final static char CH_3 = '[', CH_4 = ']';
  final static char CH_5 = '{', CH_6 = '}';

  final static String STR_1= "()", STR_2 = "[]", STR_3 = "{}";

  public static boolean isValid(String s) {
    Stack<Character> stk = new Stack();
    int len = s.length();

    for (int i = 0; i < len; i++) {
      char ch = s.charAt(i);
      if (ch == CH_1 || ch == CH_3 || ch == CH_5) {
        stk.push(ch);
      }
      if (ch == CH_2 || ch == CH_4 || ch == CH_6) {
        if (stk.empty()) {
          return false;
        }
        char top = stk.peek();
        if (ch == CH_2) {
          if (top == CH_1) {
            stk.pop();
          } else {
            return false;
          }
        }
        if (ch == CH_4) {
          if (top == CH_3) {
            stk.pop();
          } else {
            return false;
          }
        }
        if (ch == CH_6) {
          if (top == CH_5) {
            stk.pop();
          } else {
            return false;
          }
        }
      }
    }
    if (stk.empty()){
      return true;
    }
    return false;
  }

  /**
   *
   * @param str
   * @return
   */
  public static boolean isVal(String str) {

    if (str.contains(STR_1) || str.contains(STR_2) || str.contains(STR_3)) {
      return isVal(str.replace(STR_1,"").replace(STR_2,"").replace(STR_3,""));
    }
    if (str.length() == 0) {
      return true;
    }
    return false;
  }

  private HashMap<Character, Character> mappings;

  // Initialize hash map with mappings. This simply makes the code easier to read.
  public TestHashMap() {
    this.mappings = new HashMap<Character, Character>();
    this.mappings.put(')', '(');
    this.mappings.put('}', '{');
    this.mappings.put(']', '[');
  }

  public boolean isLid(String s) {

    // Initialize a stack to be used in the algorithm.
    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      // If the current character is a closing bracket.
      if (this.mappings.containsKey(c)) {

        // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
        char topElement = stack.empty() ? '#' : stack.pop();

        // If the mapping for this bracket doesn't match the stack's top element, return false.
        if (topElement != this.mappings.get(c)) {
          return false;
        }
      } else {
        // If it was an opening bracket, push to the stack.
        stack.push(c);
      }
    }

    // If the stack still contains elements, then it is an invalid expression.
    return stack.isEmpty();
  }

  /**
   * 最小k个数.
   * @param arr 数组
   * @param k k
   */
  public void kSmall(int[] arr, int k) {
    
  }

}