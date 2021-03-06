package com.es.aop;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2021-02-23 15:04
 */

public class CacheAdvisior implements PointcutAdvisor {
  @Override
  public Pointcut getPointcut() {
    return null;
  }

  @Override
  public Advice getAdvice() {
    return null;
  }

  @Override
  public boolean isPerInstance() {
    return false;
  }
}