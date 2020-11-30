package com.learn.netty.javanio;

import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;
import org.junit.jupiter.api.Test;

/**
 * @description: 测试 nio中的 buffer
 * 缓冲区是数组，用于存储不同类型数据
 * 根据数据类型不同 提供了不同的 buffer
 * 除了 boolean
 *
 * 核心方法   put()  get()
 *
 * 四个核心属性
 * capcity: 容量 一旦声明 不能改变
 * limit : 界限  缓冲区中可以操作数据的大小
 * position ：缓冲区中正在操作的数据的位置
 *
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-11-02 20:15
 */
@Slf4j(topic = "TestBuffer")
public class TestBuffer {

  public static void main(String[] args) throws IOException {

    //ByteBuffer buffer = ByteBuffer.allocate(20480);

    FileChannel fileInChannel = FileChannel.open(Paths.get("/Users/victor/Desktop/temp"), StandardOpenOption.READ,StandardOpenOption.WRITE);

    //FileChannel fileOutChannel = FileChannel.open(Paths.get("/Users/victor/Desktop/linusCopy.png"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);

    MappedByteBuffer buf =  fileInChannel.map(FileChannel.MapMode.READ_WRITE,0, 5);

    buf.put(4, (byte)'f');

    //fileInChannel.read(buffer);

    //buffer.flip();

    //fileOutChannel.write(buffer);

    Selector selector = Selector.open();

  }

}