### kafka配置  
  
下面是一些配置，[全部配置 详见-->>](http://kafka.apache.org/0101/documentation.html#configuration)    
#### 基础配置  
|   参数名   |  解释    |  默认值  |
| ---- | ---- | ---- |
|  broker.id    | kafka broker的ID，每一个broker必须有一个不重复的正整数ID     |
|  advertised.listeners    | 该broker对外暴露的地址和端口 默认端口：9092     | 127.0.0.1:9092
|  num.network.threads    | broker接受从网络过来的请求和发送响应所使用的线程数 建议：配置线程数量为cpu核数2倍，最大不超过3倍     | 3
| num.io.threads | server用来处理请求的线程数，这些线程包括I/O线程。 建议：配置线程数量为cpu核数加1 | 8
| socket.send.buffer.bytes | socket的发送缓冲区大小 | 102400
| socket.receive.buffer.bytes | socket 的接收缓冲区大小 | 104857600
| socket.request.max.bytes | 请求的最大字节数。防止内存溢出 | 104857600
| log.dirs | kafka存放数据日志的地方 |  KAFKA_HOME/logs
| num.partitions | 每一个Topic的分区数，建议：分区数和broker数相等 | 1
| replica.lag.time.max.ms | If a follower hasn't sent any fetch requests or hasn't consumed up to the leaders log end offset for at least this time, the leader will remove the follower from isr | 10000
| num.recovery.threads.per.data.dir | 每个数据目录启动时用于日志恢复和关闭时flush的的线程数。 | 1
| offsets.topic.replication.factor | 内置Topic(__consumer_offsets)默认副本数,对于开发测试以外的任何情况，建议使用大于 1 的值来确保可用性比如:3| 1
| transaction.state.log.replication.factor | 内置Topic(__transaction_state)默认副本数,对于开发测试以外的任何情况，建议使用大于 1 的值来确保可用性比如:3| 1
| transaction.state.log.min.isr | 内置Topic(__transaction_state)最小ISR,对于开发测试以外的任何情况，建议使用大于 1 的值来确保可用性比如:3| 1

#### 数据落磁盘配置（Log Flush Policy）  

消息能及时刷新到文件系统，但是在默认情况下我们用fsync()方法来惰性地同步操作系统缓存。这里有一些权衡：  
1. 持久性：没有刷新到filesystem的消息可能会丢失，如果你没有使用副本。  
2. 延时：刷新的时间间隔如果比较大,当你flush的时候可能会造成潜伏峰值（latency spikes），因为需要刷新的数据比较多。
3. 吞吐量：数据刷新（flush）到filesystem通常是比较昂贵到操作，但刷新的时间间隔较短的话会造成（excessive seeks）过多的查询。

|   参数名   |  解释    |  默认值  |
| ---- | ---- | ---- |
|  log.flush.interval.messages    |  当缓存中有 N 条消息之后执行flush操作将message刷新到filesystem  | 10000
| log.flush.interval.ms | 执行flush操作到最大间隔时间 就是每 M 毫秒执行一次flush | 1000
| log.retention.hours | 数据片段（segment）保留到时间（数据片段到大小也能配置） | 168
| log.retention.bytes | 存储文件的总大小，超过阈值则需要删除数据，需要一个segment一个segment的来删除，多出来的数据没超过segment设置大小则不删除 | 1073741824 默认不开启 
| log.segment.bytes | log.dirs目录下topic_partionNum目录下的 .log文件的 最大值 | 1073741824
| log.retention.check.interval.ms | 检查日志是否能被删除的时间间隔 | 300000

 #### zk和消费者组的配置  
 
|   参数名   |  解释    |  默认值  |
| ---- | ---- | ---- |
|  zookeeper.connect    |  链接zookeeper  | localhost:2181
|  zookeeper.connection.timeout.ms    |  链接zk的超时时间 | 6000  
|  enable.auto.commit    |  设置消费者是否可以自动提交offset | true
|  auto.commit.interval.ms    |  如果是自动提交方式提交offset设置自动提交间隔时间 | 5000  
