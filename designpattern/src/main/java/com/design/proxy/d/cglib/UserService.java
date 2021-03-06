package com.design.proxy.d.cglib;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2021-01-16 19:11
 */
public class UserService {

  public String getUserInfo(Integer uid) {
    // TODO 查询数据库
    System.out.println("查询数据库得出来的 用户信息：小明 25岁 湖南人 ");
    return " 查询数据库得出来的 用户信息：小明 25岁 湖南人 ";
  }

}