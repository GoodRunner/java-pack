# springboot

## spring boot 缓存

spring boot 可实现多种缓存 ehcache、redis、jcache等.

> 我们使用redis做缓存

1.首先引入 `spring-boot-starter-data-redis`

2.配置`RedisCacheManager`

```java
@Configuration
public class RedisCache extends CachingConfigurerSupport {

    @Bean
    public CacheManager cacheManager(@SuppressWarnings("rawtypes") RedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        //cacheManager.setExpires(); //设置过期时间
        //cacheManager.setCacheNames();// 设置缓存名称
        return cacheManager;
    }
}
```
生成CacheManager用到的RedisTemplate同样可以自定义，这个主要是与redis数据库连接用的  
service中代码直接加注解
```java
@Cacheable(value = "news")
public List<Map<String, Object>> putCache(String id){
    List<Map<String, Object>> dicWebsiteList = jdbcTemplate.queryForList("select * from news_webpage WHERE webpage_code = '"+id+"'");
    return dicWebsiteList ;
}
```  
![cacheable](https://user-images.githubusercontent.com/10717670/38196305-d26d5cfc-36b4-11e8-9368-7e338d56124e.png)
![cacheput](https://user-images.githubusercontent.com/10717670/38196309-d412644e-36b4-11e8-84da-9f6d44d58263.png)
![cacheevict](https://user-images.githubusercontent.com/10717670/38196307-d38460c2-36b4-11e8-956e-fa8b9660c997.png)

在配置文件中添加链接redis的配置   

```java
spring.redis.database=0
spring.redis.host=localhost
spring.redis.port=6379
```

## springmvc 日期转换

> `@InitBinder`注解

  在某个`controller`中添加下面的这个方法则日期转换只在本`controller`中生效

```java
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,true));
    }
```
  该注解还可以配合`@controllerAdvice`做<strong>全局</strong>的日期转换 <i>@controllerAdvice做用是把所有类中的@ExceptionHandler、@InitBinder、@ModelAttribute应用到所有的@RequestMapping方法上</i>
  ```java
  @ControllerAdvice
public class DataBinderConfig {

    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,true));

    }

}
  ```


## 发送邮件
> 添加依赖  

```
<!-- mail依赖 -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
```  

>添加配置  

```
# 你发送邮件的的host
spring.mail.host=mail.xxx.com
# 发送邮件的邮箱
spring.mail.username=xxxx@xxxx.com
# 上面这个邮箱的密码
spring.mail.password=1234xxxxxxxxxx
```

> 写发送的接口

```
    @Autowired
    private JavaMailSender sender;
```

```
@RequestMapping("/sendMsg")
@ResponseBody
public String sendMsg(String title, String msg){

    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("xxxx@xxxx.com"); //发送者 你配置的
    message.setTo("wpqloven@163.com"); //接受者
    message.setSubject(title); //发送标题
    message.setText(msg);  //发送内容
    sender.send(message);
    return "OK!";
}
```
