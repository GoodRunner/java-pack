package com.myredis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-09-27 14:20
 */
@Configuration
public class apiAdapter  extends WebMvcConfigurerAdapter {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 接口幂等性拦截器
    registry.addInterceptor(apiIdempotentInterceptor());
    super.addInterceptors(registry);
  }

  @Bean
  public ApiIdempotentInterceptor apiIdempotentInterceptor() {
    return new ApiIdempotentInterceptor();
  }

}