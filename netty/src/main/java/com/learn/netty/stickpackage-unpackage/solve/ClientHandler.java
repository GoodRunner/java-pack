package solve;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.nio.charset.Charset;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-11-25 20:48
 */
public class ClientHandler extends SimpleChannelInboundHandler<MessageProtocol> {
  @Override
  protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {

  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    // 客户端发送消息给客户端

    String str = "今天好冷啊，我熬夜熬的好深啊！";
    byte[] cnts = str.getBytes(Charset.forName("utf-8"));
    int len = cnts.length;
    for (int i = 0; i < 20; i++) {
      MessageProtocol messageProtocol = new MessageProtocol();
      messageProtocol.setContent(cnts);
      messageProtocol.setLen(len);
      ctx.writeAndFlush(messageProtocol);
    }
  }
}