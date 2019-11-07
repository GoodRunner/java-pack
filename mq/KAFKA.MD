### kafka 介绍

[官网](http://kafka.apache.org/)  

简介：  

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

##### 名词介绍

**消息**  

![record](/img/record.png)  

**主题** 
![topic](/img/topic.png)

**分区和副本**
![topic](/img/replica.png)

**leader-follower** 
![topic](/img/leader-flower.png)

**broker** 
![broker](/img/broker.png)

**生产者消费者** 
![shengchanzhexiaofeizhe](/img/pro-consu.png)

**isr** 
![isr](/img/isr.png)

**zookeeper** 
![zoo](/img/zookeepere.png)

**某一集群架构图** 
![cluster](/img/cluster.png)

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