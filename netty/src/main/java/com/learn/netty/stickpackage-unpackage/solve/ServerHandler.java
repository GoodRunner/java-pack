package solve;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.nio.charset.Charset;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-11-25 20:54
 */
public class ServerHandler extends SimpleChannelInboundHandler<MessageProtocol> {
  @Override
  protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {


    String s = new String(msg.getContent(), Charset.forName("utf-8"));

    System.out.println("服务器接收到的消息是：" + s);

  }
}