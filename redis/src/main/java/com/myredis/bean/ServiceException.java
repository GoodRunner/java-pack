package com.myredis.bean;

/**
 * @description: 自定义exception
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-09-27 13:43
 */
public class ServiceException extends RuntimeException {

  private Integer code;
  private String msg;

  public ServiceException (Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public ServiceException(final MessageEnum msgenum) {
    this(msgenum.getCode(), msgenum.getMsg());
  }

}