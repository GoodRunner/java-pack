package com.zk.config;

//import org.I0Itec.zkclient.ZkClient;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @description: config
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2019-11-25 19:25
 */
@Configuration
public class ZookeeperConfig {

  @Value("${zookeeper.address}")
  private String address;

  @Value("${zookeeper.session.time.out}")
  private int sessionTimeOut;

  @Value("${zookeeper.connect.time.out}")
  private int connectTimeOut;

  @Value("${zookeeper.retry.count}")
  private int retryCount;

  @Value("${zookeeper.retry.interval.ms}")
  private int retryInterval;

  /**
   * Curator.
   */
  @Bean
  public CuratorFramework initClient() {
    //设置重试机制
    RetryPolicy retryPolicy = new ExponentialBackoffRetry(retryInterval, retryCount);

    CuratorFramework client = CuratorFrameworkFactory.builder().connectString(address)
    .sessionTimeoutMs(sessionTimeOut).connectionTimeoutMs(connectTimeOut)
    .retryPolicy(retryPolicy)
    .build();
    client.start();
    //client.getConnectionStateListenable().addListener(new ZookeeperConnectionListener(address,1,sessionTimeout,connectTimeout,namespace));
    return client;
  }

  /**
   * 配置 zkClient.
   */
//  @Bean
//  public ZkClient zkClientInit() {
//    ZkClient client = new ZkClient(address,sessionTimeOut,connectTimeOut);
//    return client;
//  }


}