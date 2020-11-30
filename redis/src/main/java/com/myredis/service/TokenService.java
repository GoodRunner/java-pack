package com.myredis.service;

import com.myredis.bean.MessageEnum;
import com.myredis.bean.ServiceException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @description: token服务
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-09-27 11:40
 */
@Service
public class TokenService {

  private static final String TOKEN_NAME = "token";

  @Autowired
  private RedisTemplate redisTemplate;

  public void check(HttpServletRequest request) {
    String token = request.getHeader(TOKEN_NAME);

    if (StringUtils.isEmpty(token)) {
      // head 不存在 token  不存在是正常的
    } else {
      // 如果存在 报相应错误
      new ServiceException(MessageEnum.TEST_CODE);
    }

    if (redisTemplate.opsForValue().get(TOKEN_NAME) == null) {
      // redis 中不存在 是正常的
    } else {
      //存在就报错
      new ServiceException(MessageEnum.TEST_CODE);
    }

    redisTemplate.opsForValue().set(token, token);

  }

}