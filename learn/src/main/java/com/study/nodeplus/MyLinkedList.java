package com.study.nodeplus;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-05-21 17:34
 */
public class MyLinkedList {

  private Node first;

  class Node {

    private int x;

    private Node next;

    public Node(int value) {
      x = value;
    }

  }

  public boolean add(int value) {
    Node node = new Node(value);
    if (null == first) {
      first = node;
      return true;
    }else {
      Node n = null;
      return false;
    }
  }

}

