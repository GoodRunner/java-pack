### kafka配置  


|   参数名   |  解释    |  默认值  |
| ---- | ---- | ---- |
|  broker.id    | kafka broker的ID，每一个broker必须有一个不重复的正整数ID     |
|  advertised.listeners    | 该broker对外暴露的地址和端口 默认端口：9092     | 127.0.0.1:9092
|  num.network.threads    | broker接受从网络过来的请求和发送响应所使用的线程数 建议：配置线程数量为cpu核数2倍，最大不超过3倍     | 3
| num.io.threads | server用来处理请求的线程数，这些线程包括I/O线程。 建议：配置线程数量为cpu核数加1 | 8
| socket.send.buffer.bytes | socket的发送缓冲区大小 | 102400
| socket.receive.buffer.bytes | socket 的接收缓冲区大小 | 104857600
| socket.request.max.bytes | 请求的最大字节数。防止内存溢出 | 104857600

