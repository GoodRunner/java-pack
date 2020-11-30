package show;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.nio.charset.Charset;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-11-25 20:54
 */
public class ServerHandler extends SimpleChannelInboundHandler<ByteBuf> {
  @Override
  protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {

    byte[] by = new byte[msg.readableBytes()];
    msg.readBytes(by);

    String s = new String(by, Charset.forName("utf-8"));

    System.out.println("服务器接收到的消息是：" + s);

  }
}