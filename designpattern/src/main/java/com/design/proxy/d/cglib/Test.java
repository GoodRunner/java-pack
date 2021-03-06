package com.design.proxy.d.cglib;


import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2021-01-16 19:15
 */
public class Test {

  public static void main(String[] args) {

    String name = "ashjd.png";

    name = name.substring(name.indexOf("."), name.length());
    System.out.println(name);

//    final UserService userService = new UserService();
//
//    UserService o = (UserService) Enhancer.create(userService.getClass(), new MethodInterceptor() {
//      @Override
//      public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
//        System.out.println("前置增强");
//
//        method.invoke(userService, args);
//
//        System.out.println("后置增强");
//        return null;
//      }
//    });
//
//    o.getUserInfo(1);

  }

}