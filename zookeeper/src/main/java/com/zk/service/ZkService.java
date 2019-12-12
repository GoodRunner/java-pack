package com.zk.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListenerAdapter;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.schema.SchemaSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2019-12-10 16:40
 */
@Service
public class ZkService {

  @Value("${zookeeper.lock.path}")
  private String lockPath;

  @Value("${zookeeper.master.path}")
  private String masterPath;

  @Autowired
  private CuratorFramework curatorFramework;

  public String info() {

    SchemaSet set = curatorFramework.getSchemaSet();

    //curatorFramework.create().withMode(CreateMode.EPHEMERAL).forPath(keyPath);

    System.out.println(set);
    return "";
  }

  /**
   * 使用 Curator 实现master选举.
   */
  public String masterSelect()throws Exception {

    LeaderSelector selector = new LeaderSelector(curatorFramework, masterPath, new LeaderSelectorListenerAdapter() {
      @Override
      public void takeLeadership(CuratorFramework curatorFramework) throws Exception {
        System.out.println("完成master选举");
        Thread.sleep(3000);
        System.out.println("完成master操作，释放master权利");
      }
    });
    selector.autoRequeue();
    selector.start();
    //masterPath;
    Thread.sleep(1000);
    return "{\"hello\":\"world\"}";
  }

  /**
   * 使用 Curator 实现分布式锁.
   * 简单分布式锁
   * @return
   * @throws Exception
   */
  public String distriuteLock()throws Exception {

    final InterProcessMutex lock = new InterProcessMutex(curatorFramework,lockPath);
    final CountDownLatch latch = new CountDownLatch(1);

    for (int i = 0; i < 10 ; i++) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            latch.await();
            lock.acquire();
          } catch (Exception e) {
            e.printStackTrace();
          }
          SimpleDateFormat sdft = new SimpleDateFormat("HH:mm:ss|SSS");
          String order = sdft.format(new Date());
          System.out.println("生成的订单号是：" + order);
          try {
            lock.release();
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }).start();
    }
    latch.countDown();
    return "{\"hello\":\"world.you\"}";
  }

}