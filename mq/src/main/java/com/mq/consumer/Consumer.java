package com.mq.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @description: s
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2019-11-02 16:26
 */
@Component
public class Consumer {
  @KafkaListener(topics = { "mytopic" },groupId = "ttt")
  public void listen(ConsumerRecord<?, ?> record) {
    System.out.println(record);
  }
}