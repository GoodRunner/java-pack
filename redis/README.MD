## 一些笔记

1. `jedis`比`redisTemplate`执行速度要快，因为后者是对前者的更高级封装，后者更加容易让`spring`管理

2. `redisTemplate`有`jedisPool`和`lettuce`两种链接池配置

3. `jedis`和`redisTemplate`都需要`org.apache.commons.commons-pool2`包，只不过前者`jar`包中包含了，后者需要单独引入