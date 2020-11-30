package com.study.lock;

public interface Account {

  // 查询
  Integer query();


  //取钱
  void acquire(Integer i);

}
