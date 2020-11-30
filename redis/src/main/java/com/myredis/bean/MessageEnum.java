package com.myredis.bean;

public enum MessageEnum {

  TEST_CODE(8934, "fwueh");

  private Integer code;
  private String msg;


  MessageEnum (Integer code, String msg) {

  }

  public Integer getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }
}
