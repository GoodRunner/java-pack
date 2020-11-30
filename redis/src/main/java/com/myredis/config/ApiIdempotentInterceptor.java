package com.myredis.config;

import com.myredis.service.TokenService;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @description: 幂等性校验的拦截器
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-09-27 11:27
 */
public class ApiIdempotentInterceptor implements HandlerInterceptor {

  @Autowired
  private TokenService tokenService;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    HandlerMethod handlerMethod = (HandlerMethod) handler;
    Method method = handlerMethod.getMethod();

    ApiIdempotent methodAnnotation = method.getAnnotation(ApiIdempotent.class);
    // 如果有这个注解
    if (methodAnnotation != null) {
      check(request);// 幂等性校验, 校验通过则放行, 校验失败则抛出异常, 并通过统一异常处理返回友好提示
    }
    return true;
  }

  private void check(HttpServletRequest request) {
    tokenService.check(request);
  }

}