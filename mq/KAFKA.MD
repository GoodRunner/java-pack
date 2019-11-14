### kafka 介绍

[官网](http://kafka.apache.org/)  

[文档](http://kafka.apache.org/0110/documentation.html)

简介：  
```
Apache Kafka® is a distributed streaming platform. What exactly does that mean?  
（Apache Kafka 是一个分布式的流处理平台）  
A streaming platform has three key capabilities:  
（流处理平台有三个关键特性）  
Publish and subscribe to streams of records, similar to a message queue or enterprise messaging system.  
（发布和订阅记录流，类似于消息队列或企业消息传递系统）  
Store streams of records in a fault-tolerant durable way.  
（以容错的持久方式存储记录流）  
Process streams of records as they occur.  
（处理记录流）  
Kafka is generally used for two broad classes of applications:  
（Kafka 通常用于两大应用）  
Building real-time streaming data pipelines that reliably get data between systems or applications  
（构建实时数据流管道，以可靠地在系统或应用程序之间获取数据）  
Building real-time streaming applications that transform or react to the streams of data  
（构建实时流应用程序以转换或响应数据流）  

```

##### 名词介绍

**消息**  

![record](/mq/img/record.png)  

**主题** 
![topic](/mq/img/topic.png)

**分区和副本**
![topic](/mq/img/replica.png)

**leader-follower** 
![topic](/mq/img/leader-flower.png)

**broker** 
![broker](/mq/img/broker.png)

**生产者消费者** 
![shengchanzhexiaofeizhe](/mq/img/pro-consu.png)

**isr** 
![isr](/mq/img/isr.png)

**zookeeper** 
![zoo](/mq/img/zookeepere.png)

**某一集群架构图** 
![cluster](/mq/img/cluster.png)


**结构目录**  
![](/mq/img/stracture.png)  
`bin`目录下存放一些可执行的命令文件: server相关命令、生产者相关命令、消费者相关命令等  
`config`目录主要是存放一些配置文件,其中`server.properties`是主要配置文件 [详情请见-->]()  
`logs`目录下面是存放server产生的`日志`和存放在kafka中的`数据`(生产者发送到kafka中的数据会做落盘处理保存一段时间)  
需要注意的是配置文件中`log.dirs`这个配置是设置数据存放的位置的可以配置成`数据和系统日志分离`


**版本更新**  
`0.9`版本之前KAFKA消费者的偏移量存储在zookeeper中，之后的版本存储在KAFKA中`__concumer_offset`这个主题中  
`0.11`版本引入的新特性`幂等性`、`事务`

**负载**  
分区可以提高负载和并发消费  
**高可用**  
副本可以提升高可用性  

**KAFKA高速读写**  
1、零拷贝  
2、顺序写磁盘  
3、分布式  