package show;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.nio.charset.Charset;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-11-25 20:48
 */
public class ClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
  @Override
  protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {

  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    // 客户端发送消息给客户端
    for (int i = 0; i < 20; i++) {
      ByteBuf byteBuf = Unpooled.copiedBuffer("hello 你好，我是客户端 " + i, Charset.forName("utf-8"));
      ctx.channel().writeAndFlush(byteBuf);
    }
  }
}