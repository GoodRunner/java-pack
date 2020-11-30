package com.myredis.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: 校验接口幂等的注解
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-09-27 10:55
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiIdempotent {

  String value() default "这个是默认值 ～ 哈哈哈哈！";

}