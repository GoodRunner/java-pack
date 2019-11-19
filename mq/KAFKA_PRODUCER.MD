### kafka 生产者、消费者  

#### 生产者应答机制  
**acks = 0**  
如果设置成0，生产者将不等待server的响应，不能保证服务端收到消息，同时**retries**配置将不生效。这种设置丢数据都几率很大**网络波动**、**leader接收数据后宕机follower还未同步**都有可能丢失数据。  
**acks = 1**  
如果设置成1，意味着leader接收消息并把消息写在自己的本地不等待所有followers都返回就响应给生产者。这中配置如果**leader接收数据并返回ack后宕机follower还未同步**将丢失数据  
**acks = -1[all]**  
如果设置成-1，leader将等待所有ISR中都follower接收到这条消息，这能保证ISR至少有一个broker存活这条消息不丢失。这个是最健壮的设置。这个设置不会消息丢失，但是会造成消息重复**leader接收到消息isr中副本也都同步消息，leader还没发出ack宕机，生产者retries则会重复消息**
  
#### 消息压缩配置  
**compression.type = [none、gzip、snappy、lz4]**  
默认值是`none` [外部链接](https://www.cnblogs.com/tugeboke/p/11760402.html)  


#### 消费者组

消费者组是kafka实现广播的一种手段，一个topic中的一个partion只对应一个消费者组中的一个消费者