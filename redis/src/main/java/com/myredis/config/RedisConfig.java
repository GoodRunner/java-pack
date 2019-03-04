package com.myredis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;

import java.io.Serializable;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

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
  @Bean
  public RedisTemplate getTemplate(RedisConnectionFactory connectionFactory){
    RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
    redisTemplate.setConnectionFactory(connectionFactory);
    return redisTemplate;
  }

  /*@Bean
  public JedisPool configPool(){

    JedisPoolConfig poolConfig = new JedisPoolConfig();
    poolConfig.setMaxIdle(Integer.valueOf(maxIdle));
    poolConfig.setMinIdle(Integer.valueOf(minIdle));
    poolConfig.setMaxWaitMillis(Integer.valueOf(maxWait));
    poolConfig.setMaxTotal(Integer.valueOf(maxTotal));
    JedisPool pool = new JedisPool(poolConfig, host, Integer.valueOf(port), Integer.valueOf(timeout).intValue(), password, Integer.valueOf(database).intValue(), false);

    return pool;
  }*/

  @Bean
  public CacheManager cacheManager(RedisConnectionFactory factory) {
    RedisCacheManager cacheManager = new RedisCacheManager(
            RedisCacheWriter.nonLockingRedisCacheWriter(factory),
            /* 默认的策略   为配置的key都执行这个策略 */
            this.getRedisCacheConfigurationWithTtl(20)
            //this.getRedisCacheConfigurationMap() // 指定 key 策略
            );
    return cacheManager;
  }

  private RedisCacheConfiguration getRedisCacheConfigurationWithTtl(Integer seconds) {

    RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();

    redisCacheConfiguration = redisCacheConfiguration.entryTtl(Duration.ofSeconds(seconds));

    return redisCacheConfiguration;
  }

  private Map<String, RedisCacheConfiguration> getRedisCacheConfigurationMap() {

    Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
    redisCacheConfigurationMap.put("UserInfoList", this.getRedisCacheConfigurationWithTtl(3000));
    redisCacheConfigurationMap.put("UserInfoListAnother",
            this.getRedisCacheConfigurationWithTtl(18000));

    return redisCacheConfigurationMap;
  }

}
