## rabbitmq

> 一些基本概念

Message：消息，消息队列中信息或数据的传递载体。

Producer：消息生产者，即投递消息的程序。

Consumer：消息的消费者，即接受消息的程序。

Broker：简单来说就是消息队列服务器实体，即Rabbitmq Server。

Binding：绑定，它的作用就是把exchange和queue按照路由规则绑定起来。

Queue：队列，负责保存消息和发放消息。

Routing Key：路由关键字，Exchange根据这个关键字进行消息投递。

Exchange：接收消息，并转发到绑定的队列。

vhost：虚拟主机，一个broker里可以开设多个vhost，用作不同用户的权限分离。

channel：消息通道，在客户端的每个连接里，可建立多个channel，每个channel代表一个会话任务

![rabbitmq](https://user-images.githubusercontent.com/10717670/44129073-0a66f02c-a079-11e8-8df2-6e81c36f6836.png)

> 队列的持久化 VS 消息的持久化

1. 将`queue`的持久化标识`durable`设置为`true`,则代表是一个持久的队列，在服务重启之后，队列也会存在

2. 消息的持久化
```
channel.basicPublish(exchangename, "bindingkey", MessageProperties.PERSISTENT_TEXT_PLAIN, "hello world!".getBytes());
```
主要是 `MessageProperties.PERSISTENT_TEXT_PLAIN`这个参数中`deliveryMode=2`代表持久化

单只设置队列持久化，重启之后消息会丢失；单只设置消息的持久化，重启之后队列消失，既而消息也丢失。单单设置消息持久化而不设置队列的持久化显得毫无意义。

> 防止消息丢失的策略

设置了队列、消息、交换器的持久化后并不能保证消息一定不会丢失。

丢失场景和解决方法：

    1. autoack参数被设置成true,在消费者接收消息后没处理完成消费者的服务器就宕机了，这认为是消息的丢失。只要把autoack参数设置成false,由消费者手动确认消息接收成功，即可。
    
    2. 生产者的消息未能成功到达rabbitmq的broker。 加入生产者确认机制
    
    3. 在mq的消息，还需要有一段时间（这个时间很短，但不可忽视）才能存入磁盘之中，当在这个没存入磁盘的中间，服务器宕机了，会导致消息丢失。，解决方法是添加双机镜像队列。
    
> 消息的顺序性

认为`rabbitmq`是保证顺序的结论是片面的，在一个消费者，网络良好，一个消费者，没有使用`rabbitmq`高级特性的情况下，顺序是可以保证的。

顺序不能保证的情况有

1. 生产者使用消息确认机制，在没有送达的情况下，消息重发。
2. 消费者在消费消息的时候手动确认没有回应，或者`reject`消息，并且`requeue`属性是`true`，消息会重新进入队列发送给其他消费者。
3. 消息设置了不同的过期时间进入`死信队列`（大致就是一个延时队列），顺序不能保证。
4. 使用优先级队列，消息不能保证顺序。
