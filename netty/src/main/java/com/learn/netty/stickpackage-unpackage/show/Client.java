package show;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-11-25 20:42
 */
public class Client {

  public static void main(String[] args) throws InterruptedException {

    NioEventLoopGroup worker = new NioEventLoopGroup(4);

    try {
      Bootstrap bootstrap = new Bootstrap();

      bootstrap.group(worker);
      bootstrap.channel(NioSocketChannel.class).handler(new ClientInitializer());

      ChannelFuture localhost = bootstrap.connect("localhost", 7000);
      localhost.channel().closeFuture().sync();
    } catch (Exception e) {
      worker.shutdownGracefully();
    }
  }

}