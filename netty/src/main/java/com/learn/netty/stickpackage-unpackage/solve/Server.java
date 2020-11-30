package solve;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-11-25 20:38
 */
public class Server {


  public static void main(String[] args) throws InterruptedException {

    NioEventLoopGroup boss = new NioEventLoopGroup();
    NioEventLoopGroup worker = new NioEventLoopGroup(4);
    try {
      ServerBootstrap bootstrap = new ServerBootstrap();

      bootstrap.group(boss, worker);
      bootstrap.channel(NioServerSocketChannel.class).childHandler(new ServerInitializer());

      ChannelFuture sync = bootstrap.bind(8000).sync();
      sync.channel().closeFuture().sync();
    } catch (Exception e) {
      boss.shutdownGracefully();
      worker.shutdownGracefully();
    }
  }


}