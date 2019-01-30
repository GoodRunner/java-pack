package com.myredis.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

  @Value("${spring.redis.host}")
  private String host;

  @Value("${spring.redis.port}")
  private String port;

  @Value("${spring.redis.password}")
  private String password;

  @Value("${spring.redis.database}")
  private String database;

  @Value("${spring.redis.timeout}")
  private String timeout;

  @Value("${spring.redis.jedis.pool.maxTotal}")
  private String maxTotal;

  @Value("${spring.redis.jedis.pool.maxIdle}")
  private String maxIdle;

  @Value("${spring.redis.jedis.pool.minIdle}")
  private String minIdle;

  @Value("${spring.redis.jedis.pool.maxWait}")
  private String maxWait;

  //如果使用 RedisTemplate 的话只需要配置一个这个，在配置文件中配置数据库链接地址就可以了
  /*@Bean
  public RedisTemplate getTemplate(RedisConnectionFactory connectionFactory){
    RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
    redisTemplate.setConnectionFactory(connectionFactory);
    return redisTemplate;
  }*/

  @Bean
  public JedisPool configPool(){

    JedisPoolConfig poolConfig = new JedisPoolConfig();
    poolConfig.setMaxIdle(Integer.valueOf(maxIdle));
    poolConfig.setMinIdle(Integer.valueOf(minIdle));
    poolConfig.setMaxWaitMillis(Integer.valueOf(maxWait));
    poolConfig.setMaxTotal(Integer.valueOf(maxTotal));
    JedisPool pool = new JedisPool(poolConfig, host, Integer.valueOf(port), Integer.valueOf(timeout).intValue(), password, Integer.valueOf(database).intValue(), false);

    return pool;
  }

}
