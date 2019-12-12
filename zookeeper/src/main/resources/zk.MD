### zookeeper  
    ZooKeeper是一个分布式的，开放源码的分布式应用程序协调服务，是Google的Chubby一个开源的实现，是Hadoop的重要组件
#### 主要解决的问题  
它主要是用来解决分布式应用中经常遇到的一些数据管理问题，如：统一命名服务、状态同步服务（分布式锁）、集群管理、分布式应用配置项的管理、负载均衡、分布式队列等。

#### java客户端  
`org.apache.zookeeper.zookeeper`、`zkclient`、`curator`

#### zk中的角色  

1. leader：领导者负责进行投票的发起与决议，更新系统状态，写数据，查看数据  
2. follower：用于接收客户端请求并向客户端返回结果，在选举过程中参与投票  
3. observer：可以接收客户端连接，将写请求转发给leader节点，但observer不参与投票过程，只同步leader的状态。observer的目的是为了扩展系统，提高读写速度  

![zk架构](../../../img/zkframwork.png)

[zab协议](https://blog.csdn.net/jin5203344/article/details/53142027)  
[好文推荐](https://www.cnblogs.com/sunddenly/articles/4143859.html)