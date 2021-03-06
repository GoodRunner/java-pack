package com.es.aop;

import com.es.common.EasyCache;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AopUtils;
import org.springframework.core.annotation.AnnotatedElementUtils;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2021-02-23 15:08
 */
public class CachePointCut implements Pointcut, MethodMatcher {


  @Override
  public ClassFilter getClassFilter() {
    return ClassFilter.TRUE;
  }

  @Override
  public MethodMatcher getMethodMatcher() {
    return this;
  }

  @Override
  public boolean matches(Method method, Class<?> aClass) {
    // todo 需要写自己的逻辑

    // 获取原始方法
    Method specificMethod = AopUtils.getMostSpecificMethod(method, aClass);
    // 查看方法上是否有该注解
    if (AnnotatedElementUtils.hasAnnotation(specificMethod, EasyCache.class)) {

    }

    return false;
  }

  @Override
  public boolean isRuntime() {
    return false;
  }

  @Override
  public boolean matches(Method method, Class<?> aClass, Object... objects) {
    return false;
  }
}